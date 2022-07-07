import cv2
import numpy as np

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
    #########################################################
    # TODO                                                  #
    # dst 완성                                              #
    # dst : filtering 결과 image                            #
    #########################################################

    # if stride 1
    (i_h, i_w) = src_pad.shape


    (k_h, k_w) = mask.shape
    (p_size_h, p_size_w) = (mask.shape[0] // 2, mask.shape[1] // 2)

    o_h = (h - k_h + 2 * p_size_h) // 1 + 1
    o_w = (w - k_w + 2 * p_size_w) // 1 + 1


    for i in range(o_h):
        for j in range(o_w):
            temp = np.sum(src_pad[i:i + k_h, j:j + k_w] * mask)
            dst[i, j] = temp

    # pixel save
    # dst = np.where(dst > 255, 255, dst)
    #dst = np.where(dst < 0, 0, dst)

    return dst
