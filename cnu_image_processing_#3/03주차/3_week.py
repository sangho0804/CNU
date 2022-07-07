import numpy as np
import cv2
import matplotlib.pyplot as plt
from sympy import principal_branch


def my_calcHist(img):
    (h, w) = img.shape
    hist = np.zeros((256,))

    for row in range(h):
        for col in range(w):
            hist[img[row][col]] += 1

    return hist

def my_PDF2CDF(pdf):
    cdf = np.zeros((256,))
    cdf[0] = pdf[0]
    for i in range(1, 256):
        cdf[i] = pdf[i] + cdf[i-1];
    return cdf



def my_normalize_hist(hist, pixel_num):
    normalized_hist = np.array([i/pixel_num for i in hist])
    return normalized_hist

def my_denormallize(normalized, gray_level):
    denormalized = np.array([i * gray_level for i in normalized])
    return denormalized

def my_calcHist_equalization(denormalized, hist):

    hist_equal = np.zeros((256,))
    for i in range(256):
        hist_equal[denormalized[i]] += hist[i]
    return hist_equal


def my_equal_img(src, gray_level):
    (h, w) = src.shape
    dst = np.zeros((h, w) , dtype=np.uint8)
    for row in range(h):
        for col in range(w):
            dst[row, col] = gray_level[src[row, col]]
    return dst

#input_image의  equalization된 histogram & image 를 return
def my_hist_equal(src):
    (h, w) = src.shape
    max_gray_level = 255
    histogram = my_calcHist(src)
    normalized_histogram = my_normalize_hist(histogram, h * w)
    normalized_output = my_PDF2CDF(normalized_histogram)
    denormalized_output = my_denormallize(normalized_output, max_gray_level)
    output_gray_level = denormalized_output.astype(int)
    hist_equal = my_calcHist_equalization(output_gray_level, histogram)

    ### dst : equalization 결과 image
    dst = my_equal_img(src, output_gray_level)

    return dst, hist_equal

if __name__ == '__main__':
    # Test on simple matrix

    test_img = np.array([[0, 1, 1, 1, 2], [2, 3, 3, 3, 3],
                    [3, 3, 3, 4, 4], [4, 4, 4, 4, 4],
                    [4, 5, 5, 5, 7]], dtype=np.uint8)
    hist = my_calcHist(test_img)
    dst, hist_equal = my_hist_equal(test_img)

    test_img_to_show = cv2.resize(test_img, dsize=(512, 512), interpolation=cv2.INTER_NEAREST)
    cv2.imshow('equalizetion before image', test_img_to_show)
    test_dst_to_show = cv2.resize(dst, dsize=(512, 512), interpolation=cv2.INTER_NEAREST)
    cv2.imshow('equalizetion after image', test_dst_to_show)

    plt.figure(1)
    plt.title('my histogram')
    plt.bar(np.arange(len(hist)), hist, width=0.5, color='g')

    plt.figure(2)
    plt.title('my histogram equalization')
    plt.bar(np.arange(len(hist_equal)), hist_equal, width=0.8, color='g')

    plt.show()
    cv2.waitKey()
    cv2.destroyAllWindows()

    # Test on real image
    test_img = cv2.imread('fruits.jpg', cv2.IMREAD_GRAYSCALE)
    hist = my_calcHist(test_img)
    dst, hist_equal = my_hist_equal(test_img)

    cv2.imshow('equalizetion before image', test_img)
    cv2.imshow('equalizetion after image', dst)

    plt.figure(1)
    plt.title('my histogram')
    plt.bar(np.arange(len(hist)), hist, width=0.5, color='g')

    plt.figure(2)
    plt.title('my histogram equalization')
    plt.bar(np.arange(len(hist_equal)), hist_equal, width=0.8, color='g')

    plt.show()
    cv2.waitKey()
    cv2.destroyAllWindows()