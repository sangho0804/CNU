import cv2
import numpy as np
import matplotlib.pyplot as plt


def apply_threshold(img, th=120):
    ######################################################
    # TODO                                               #
    # 실습시간에 배포된 코드 사용                             #
    ######################################################
    dst = np.zeros(img.shape, img.dtype)
    dst[img >= th] = 255
    dst[img < th] = 0
    return dst

def adaptive_threshold(img, group_num=4):
    img_split = np.hsplit(img, group_num)

    thresholds = list()
    dst = list()

    for img_part in img_split:
        val, dst_part = cv2.threshold(img_part, 0, 255, cv2.THRESH_OTSU)
        thresholds.append(val)
        dst.append(dst_part)

    dst = np.concatenate(dst, axis = 1)

    return dst, thresholds

def my_otsu_threshold(img):
    hist, bins = np.histogram(img.ravel(),256,[0,256])
    p = hist / (np.sum(hist) + 1e-7)

    ######################################################
    # TODO                                               #
    # Otsu 방법을 통해 threshold 구한 후 이진화 수행          #
    # cv2의 threshold 와 같은 값이 나와야 함                 #
    ######################################################

    k_opt_varw = []

    for k in range(256):

        q1 = p[:k + 1]
        q2 = p[k + 1:]
        q1sum = np.sum(p[:k + 1])
        q2sum = np.sum(p[k + 1:])

        if q1sum == 0 or q2sum == 0:
            k_opt_varw.append(np.inf)
            continue

        i1 = [i for i in range(k + 1)]
        i2 = [i for i in range(k + 1, 256)]
        m1 = np.sum(np.multiply(i1, q1)) / q1sum
        m2 = np.sum(np.multiply(i2, q2)) / q2sum

        i3 = [i ** 2 for i in range(k + 1)]
        i4 = [i ** 2 for i in range(k + 1, 256)]
        var1 = np.sum(np.multiply(i3, q1)) / q1sum - np.multiply(m1, m1)
        var2 = np.sum(np.multiply(i4, q2)) / q2sum - np.multiply(m2, m2)

        varw = q1sum * var1 + q2sum * var2

        k_opt_varw.append(varw)

    k_opt_varw = np.array(k_opt_varw)

    th = k_opt_varw.argmin()
    dst = apply_threshold(img, th)

    return th, dst

if __name__ == '__main__':
    img = cv2.imread('cameraman.tif', cv2.IMREAD_GRAYSCALE)

    th_cv2, dst_cv2 = cv2.threshold(img, 0, 255, cv2.THRESH_OTSU)

    th_my, dst_my = my_otsu_threshold(img)

    print('Threshold from cv2: {}'.format(th_cv2))
    print('Threshold from my: {}'.format(th_my))

    cv2.imshow('original image', img)
    cv2.imshow('cv2 threshold', dst_cv2)
    cv2.imshow('my threshold', dst_my)

    plt.hist(img.ravel(), 256, [0, 256])
    plt.show()
    cv2.waitKey(0)
    cv2.destroyAllWindows()


