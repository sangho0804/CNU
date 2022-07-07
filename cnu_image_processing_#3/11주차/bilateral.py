import numpy as np
import cv2
import time



def my_padding(src, pad_shape, pad_type='zero'):
    (h, w) = src.shape
    (p_h, p_w) = pad_shape
    pad_img = np.zeros((h+2*p_h, w+2*p_w))
    pad_img[p_h:p_h+h, p_w:p_w+w] = src

    if pad_type == 'repetition':
        print('repetition padding')
        #up
        pad_img[:p_h, p_w:p_w+w] = src[0, :]
        #down
        pad_img[p_h+h:, p_w:p_w+w] = src[h-1, :]

        #left
        pad_img[:,:p_w] = pad_img[:, p_w:p_w + 1]
        #right
        pad_img[:, p_w+w:] = pad_img[:, p_w+w-1:p_w+w]

    return pad_img

def my_filtering(src, filter, pad_type='zero'):
    (h, w) = src.shape
    (f_h, f_w) = filter.shape
    src_pad = my_padding(src, (f_h//2, f_w//2), pad_type)
    dst = np.zeros((h, w))

    for row in range(h):
        for col in range(w):
            val = np.sum(src_pad[row:row+f_h, col:col+f_w] * filter)
            dst[row, col] = val

    return dst

def my_get_Gaussian2D_mask(msize, sigma=1):
    y, x = np.mgrid[-(msize // 2):(msize // 2) + 1, -(msize // 2):(msize // 2) + 1]

    #2차 gaussian mask 생성
    gaus2D =   1 / (2 * np.pi * sigma**2) * np.exp(-(( x**2 + y**2 )/(2 * sigma**2)))
    #mask의 총 합 = 1
    gaus2D /= np.sum(gaus2D)

    return gaus2D

def my_normalize(src):
    dst = src.copy()
    dst *= 255
    dst = np.clip(dst, 0, 255)
    return dst.astype(np.uint8)

def add_gaus_noise(src, mean=0, sigma=0.1):
    #src : 0 ~ 255, dst : 0 ~ 1
    dst = src/255
    h, w = dst.shape
    noise = np.random.normal(mean, sigma, size=(h, w))
    dst += noise
    return my_normalize(dst)

def my_bilateral(src, msize, sigma, sigma_r, pad_type='zero'):
    ####################################################################################################
    # TODO                                                                                             #
    # my_bilateral 완성                                                                                 #
    # mask를 만들 때 4중 for문으로 구현 시 감점(if문 fsize*fsize개를 사용해서 구현해도 감점)                     #
    ####################################################################################################
    (h, w) = src.shape

    dst = np.zeros((h, w))

    #mask 를 씌우기 위해 padding
    img_pad = my_padding(src, (int(msize / 2), int(msize / 2)), pad_type)


    y, x = np.mgrid[-int(msize / 2):int(msize / 2) + 1, -int(msize / 2):int(msize / 2) + 1]
    #exp1
    exp1 = np.exp(-((x ** 2 + y ** 2) / (2 * sigma ** 2)))


    for i in range(h):
        print('\r%d / %d ...' %(i,h), end="")
        for j in range(w):
            diff = src[i, j] - img_pad[i + int(msize / 2) + y, j + int(msize / 2) + x]  # I[i, j] - I[k, l]
            exp2 = np.exp(-(diff ** 2) / (2 * sigma_r ** 2))
            mask = exp1 * exp2


            mask /= np.sum(mask)  # EXP1 * EXP2 / N

            dst[i, j] = np.sum(mask * img_pad[i:i+msize, j:j+msize])


    return dst



if __name__ == '__main__':
    start = time.time()
    src = cv2.imread('Lenna.png', cv2.IMREAD_GRAYSCALE)
    np.random.seed(seed=100)

    pos_y = 0
    pos_x = 0
    src_noise = add_gaus_noise(src, mean=0, sigma=0.1)
    src_noise = src_noise/255

    ######################################################
    # TODO                                               #
    # my_bilateral, gaussian mask 채우기                  #
    ######################################################
    dst = my_bilateral(src_noise, 5, 3, 0.1)
    dst = my_normalize(dst)

    # test sigma = 3 , 5
    gaus2D = my_get_Gaussian2D_mask(5 , sigma = 5)
    dst_gaus2D= my_filtering(src_noise, gaus2D)
    dst_gaus2D = my_normalize(dst_gaus2D)

    cv2.imshow('original', src)
    cv2.imshow('gaus noise', src_noise)
    cv2.imshow('my gaussian', dst_gaus2D)
    cv2.imshow('my bilateral', dst)
    tital_time = time.time() - start
    print('\ntime : ', tital_time)
    if tital_time > 25:
        print('감점 예정입니다. 코드 수정을 추천드립니다.')
    cv2.waitKey()
    cv2.destroyAllWindows()
