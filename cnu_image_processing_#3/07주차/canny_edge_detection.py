import cv2
import numpy as np
from collections import deque

def my_padding(src, pad_shape, pad_type='zero'):
    (h, w) = src.shape
    (p_h, p_w) = pad_shape
    pad_img = np.zeros((h + 2 * p_h, w + 2 * p_w))
    pad_img[p_h:p_h + h, p_w:p_w + w] = src

    if pad_type == 'repetition':
        print('repetition padding')

        # up
        pad_img[:p_h, p_w:p_w + w] = src[0, :]
        # down
        pad_img[p_h + h:, p_w:p_w + w] = src[h - 1, :]
        # left
        pad_img[:, :p_w] = pad_img[:, p_w:p_w + 1]
        # right
        pad_img[:, p_w + w:] = pad_img[:, p_w + w - 1:p_w + w]

    else:
        print('zero padding')

    return pad_img


def my_filtering(src, mask, pad_type='zero'):
    (h, w) = src.shape
    src_pad = my_padding(src, (mask.shape[0] // 2, mask.shape[1] // 2), pad_type)
    dst = np.zeros((h, w))

    for row in range(h):
        for col in range(w):
            val = np.sum(src_pad[row:row + mask.shape[0], col:col + mask.shape[1]] * mask)
            dst[row, col] = val

    return dst


def get_Gaussian_mask(fsize, sigma=1):
    y, x = np.mgrid[-(fsize // 2):(fsize // 2) + 1, -(fsize // 2):(fsize // 2) + 1]

    # 2차 gaussian mask 생성
    gaus2D = 1 / (2 * np.pi * sigma ** 2) * np.exp(-((x ** 2 + y ** 2) / (2 * sigma ** 2)))
    # mask의 총 합 = 1
    gaus2D /= np.sum(gaus2D)

    return gaus2D


def get_sobel_mask():
    derivative = np.array([[-1, 0, 1]])
    blur = np.array([[1], [2], [1]])

    x = np.dot(blur, derivative)
    y = np.dot(derivative.T, blur.T)

    return x, y


def apply_gaussian_filter(src, fsize=3, sigma=1):
    #####################################################
    # TODO                                              #
    # src에 gaussian filter 적용                         #
    #####################################################
    dst = my_filtering(src, get_Gaussian_mask(fsize, sigma))

    return dst


def apply_sobel_filter(src):
    #####################################################
    # TODO                                              #
    # src에 sobel filter 적용                            #
    #####################################################
    x,y = get_sobel_mask()
    Ix, Iy = my_filtering(src,x) , my_filtering(src, y)
    return Ix, Iy


def calc_magnitude(Ix, Iy):
    #####################################################
    # TODO                                              #
    # Ix, Iy 로부터 magnitude 계산                        #
    #####################################################

    magnitude = np.sqrt(Ix ** 2 + Iy ** 2)

    return magnitude


def calc_angle(Ix, Iy, eps=1e-6):
    #####################################################
    # TODO                                              #
    # Ix, Iy 로부터 angle 계산                            #
    # numpy의 arctan 사용 O, arctan2 사용 X               #
    # 호도법이나 육십분법이나 상관 X                         #
    # eps     : Divide by zero 방지용                    #
    #####################################################
    angle = np.arctan(Iy / (Ix + eps))  # 0으로 나눠지는거 방지
    return np.rad2deg(angle)



def non_maximum_supression(magnitude, angle):
    ####################################################################################
    # TODO                                                                             #
    # Non-maximum-supression 수행                                                       #
    # 스켈레톤 코드는 angle이 육십분법으로 나타나져 있을 것으로 가정                             #
    ####################################################################################
    (h, w) = magnitude.shape
    # angle의 범위 : -90 ~ 90
    largest_magnitude = np.zeros((h, w))
    for row in range(1, h - 1):
        for col in range(1, w - 1):
            degree = angle[row, col]
            # 각도가 d일 때
            # d 각도의 픽셀과 동시에 180 + d 각도 방향의 픽셀과도 비교 해야함.
            # ex) 10도와 190도 -> 대략 우측과 좌측 픽셀
            # interpolation 방법은 linear로 구현
            ratian = np.deg2rad(degree)
            if 0 <= degree and degree < 45:
                rat = np.tan(ratian)
                p = magnitude[row, col + 1] * (1 - rat) + magnitude[row + 1, col + 1] * rat
                r = magnitude[row, col - 1] * (1 - rat) + magnitude[row - 1, col - 1] * rat

            elif 45 <= degree and degree <= 90:
                rat = np.tan(np.pi/2-ratian)
                p = magnitude[row + 1, col] * (1 - rat) + magnitude[row + 1, col + 1] * rat
                r = magnitude[row - 1, col] * (1 - rat) + magnitude[row - 1, col - 1] * rat
            elif -45 <= degree and degree < 0:
                rat = np.tan(-ratian)
                p = magnitude[row, col + 1] * (1 - rat) + magnitude[row - 1, col + 1] * rat
                r = magnitude[row, col - 1] * (1 - rat) + magnitude[row + 1, col - 1] * rat
            elif -90 <= degree and degree < -45:
                rat = np.tan(ratian + np.pi/2)
                p = magnitude[row - 1, col] * (1 - rat) + magnitude[row - 1, col + 1] * rat
                r = magnitude[row + 1, col] * (1 - rat) + magnitude[row + 1, col - 1] * rat
            else:
                print(row, col, 'error!  degree :', degree)
            if magnitude[row, col] == max(p,r,magnitude[row,col]):
                largest_magnitude[row,col] = magnitude[row,col]
    return largest_magnitude


def double_thresholding(src):
    dst = src.copy()

    # dst 범위 조정 0 ~ 255
    dst = (dst - np.min(dst)) / (np.max(dst) - np.min(dst))
    dst *= 255
    dst = dst.astype('uint8')

    # threshold는 정해진 값을 사용
    high_threshold_value = 40
    low_threshold_value = 5

    print(high_threshold_value, low_threshold_value)

    #####################################################
    # TODO                                              #
    # Double thresholding 수행                           #
    #####################################################
    (h, w) = dst.shape
    # 강한 엣지는 255로, 약한 엣지는 100으로 설정.
    for row in range(h):
        for col in range(w):
            if dst[row][col] >= int(high_threshold_value):
                dst[row][col] = 255
            elif dst[row][col] < int(low_threshold_value):
                dst[row][col] = 0
            else:
                dst[row][col] = 100

    for row in range(h):
        for col in range(w):
            if dst[row][col] == 255:
                mid = deque()
                mid.append((row, col))
                while mid:  # BFS 진행
                    x, y = mid.popleft()
                    dx = [-1, -1, -1, 0, 0, 1, 1, 1]
                    dy = [-1, 0, 1, -1, 1, -1, 0, 1]
                    for k in range(8):
                        nx = x + dx[k]
                        ny = y + dy[k]
                        if nx >= 0 and nx < h and ny >= 0 and ny < w and dst[nx][ny] == 100:  # 약한 엣지인 경우
                            mid.append((nx, ny))
                            dst[nx][ny] = 255  # 강한 엣지로 만들어 준다.

        # 강한 엣지로 변환되지 않은 약한 엣지는 0으로.
    for row in range(h):
        for col in range(w):
            if dst[row][col] != 255:
                dst[row][col] = 0

    # return dst
    dst = dst.astype('float32') / 255.0
    return dst


def canny_edge_detection(src):
    # Apply low pass filter
    I = apply_gaussian_filter(src, fsize=3, sigma=1)

    # Apply high pass filter
    Ix, Iy = apply_sobel_filter(I)

    # Get magnitude and angle
    magnitude = calc_magnitude(Ix, Iy)
    angle = calc_angle(Ix, Iy)

    # Apply non-maximum-supression
    after_nms = non_maximum_supression(magnitude, angle)

    # Apply double thresholding
    dst = double_thresholding(after_nms)

    return dst, after_nms, magnitude


if __name__ == '__main__':
    img = cv2.imread('Lenna.png', cv2.IMREAD_GRAYSCALE).astype('float32') / 255.0

    canny, after_nms, magnitude = canny_edge_detection(img)

    # 시각화 하기 위해 0~1로 normalize (min-max scaling)
    magnitude = (magnitude - np.min(magnitude)) / (np.max(magnitude) - np.min(magnitude))
    after_nms = (after_nms - np.min(after_nms)) / (np.max(after_nms) - np.min(after_nms))

    cv2.imshow('original', img)
    cv2.imshow('magnitude', magnitude)
    cv2.imshow('after_nms', after_nms)
    cv2.imshow('canny_edge', canny)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

