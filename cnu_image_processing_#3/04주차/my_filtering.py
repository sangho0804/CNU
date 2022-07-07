import cv2
import numpy as np

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

    else:
        print('zero padding')

    return pad_img

def my_filtering(src, mask, pad_type='zero'):
    (h, w) = src.shape
    src_pad = my_padding(src, (mask.shape[0]//2, mask.shape[1]//2), pad_type)
    dst = np.zeros((h, w))
    #########################################################
    # TODO                                                  #
    # dst 완성                                              #
    # dst : filtering 결과 image                            #
    #########################################################

    #if stride 1
    (i_h, i_w) = src_pad.shape
   # print("srcpad : " , i_h , i_w)

    (k_h, k_w) = mask.shape
    (p_size_h , p_size_w) = (mask.shape[0]//2, mask.shape[1]//2)

    o_h = (h - k_h + 2 * p_size_h) // 1 + 1
    o_w = (w - k_w + 2 * p_size_w) // 1 + 1

    #print("out : " , o_h , o_w)

    for i in range(o_h):
        for j in range (o_w):
            cut_img = src_pad[i:i + k_h, j:j + k_w]
            dst[i, j] = np.sum(mask * cut_img)

    #pixel save
    dst = np.where(dst > 255, 255, dst)
    dst = np.where(dst < 0, 0, dst)


    dst = (dst+0.5).astype(np.uint8)

    return dst
    
def get_average_mask(fshape):
    print('get average filter')
    ###################################################
    # TODO                                            #
    # mask 완성                                       #
    ###################################################
    (k_h, k_w) =fshape
    k_size = k_h * k_w
    mask = np.full((k_h , k_w) , 1 / k_size)

    # mask 확인
    print(mask)
    
    return mask
    
def get_sharpening_mask(fshape):
    print('get sharpening filter')
    ##################################################
    # TODO                                           #
    # mask 완성                                      #
    ##################################################

    (k_h, k_w) = fshape
    k_size = k_h * k_w
    mask = np.full((k_h, k_w), 1 / k_size)

    k_sh = np.zeros((k_h, k_w))
    k_sh [k_h // 2][k_w // 2] = 2
    mask = k_sh - mask
    print(fshape)


    #mask 확인
    print(mask)
    
    return mask


if __name__ == '__main__':
    src = cv2.imread('Lenna.png', cv2.IMREAD_GRAYSCALE)

    # 3x3 filter
    dst_average_3x3 = my_filtering(src, get_average_mask(fshape=(3,3)))
    dst_sharpening_3x3 = my_filtering(src, get_sharpening_mask(fshape=(3,3)))

    # 11x13 filter
    dst_average_11x13 = my_filtering(src, get_average_mask(fshape=(11,13)))
    dst_sharpening_11x13 = my_filtering(src, get_sharpening_mask(fshape=(11,13)))

    cv2.imshow('original', src)
    cv2.imshow('average filter 3x3', dst_average_3x3)
    cv2.imshow('sharpening filter 3x3', dst_sharpening_3x3)
    cv2.imshow('average filter 11x13', dst_average_11x13)
    cv2.imshow('sharpening filter 11x13', dst_sharpening_11x13)
    
    cv2.waitKey(0)
    cv2.destroyAllWindows()
