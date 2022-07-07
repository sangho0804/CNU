import numpy as np
import cv2
import time

import warnings
warnings.filterwarnings("ignore", category=np.VisibleDeprecationWarning)

pos = [[0, 1, 5, 6, 14, 15, 27, 28],
       [2, 4, 7, 13, 16, 26, 29, 42],
       [3, 8, 12, 17, 25, 30, 41, 43],
       [9, 11, 18, 24, 31, 40, 44, 53],
       [10, 19, 23, 32, 39, 45, 52, 54],
       [20, 22, 33, 38, 46, 51, 55, 60],
       [21, 34, 37, 47, 50, 56, 59, 61],
       [35, 36, 48, 49, 57, 58, 62, 63]]

sort_pos = []
for i in range(8):
    for j in range(8):
        sort_pos.append((pos[i][j], i, j))

sort_pos.sort()


def C(w, n):
    if w == 0:
        return (1 / n) ** 0.5
    else:
        return (2 / n) ** 0.5


def C_inv(w, n=8):
    dst = np.zeros((n, n))
    for i in range(n):
        for j in range(n):
            if w[i][j] == 0:
                dst[i][j] = (1 / n) ** 0.5
            else:
                dst[i][j] = (2 / n) ** 0.5
    return dst


def Quantization_Luminance(scale_factor):
    luminance = np.array(
        [[16, 11, 10, 16, 24, 40, 51, 61],
         [12, 12, 14, 19, 26, 58, 60, 55],
         [14, 13, 16, 24, 40, 57, 69, 56],
         [14, 17, 22, 29, 51, 87, 80, 62],
         [18, 22, 37, 56, 68, 109, 103, 77],
         [24, 35, 55, 64, 81, 104, 113, 92],
         [49, 64, 78, 87, 103, 121, 120, 101],
         [72, 92, 95, 98, 112, 100, 103, 99]])
    return luminance * scale_factor


def img2block(src, n=8):
    ######################################
    # TODO                               #
    # img2block 완성                      #
    # img를 block으로 변환하기              #
    # blocks : 각 block을 추가한 list       #
    # return value : np.array(blocks)     #
    ######################################
    (h, w) = src.shape
    blocks = []

    for i in range(h // n):
        for j in range(w // n):
            blocks.append(src[i * n:(i + 1) * n, j * n:(j + 1) * n])

    return np.array(blocks).astype(np.float32)



def DCT(block, n=8):
    ######################################
    # TODO                               #
    # DCT 완성                            #
    ######################################
    dst = np.zeros(block.shape)

    v, u = dst.shape
    y, x = np.mgrid[0:u, 0:v]

    for v_ in range(v):
        for u_ in range(u):
            mask = block * np.cos(((2 * x + 1) * u_ * np.pi) / (2 * n)) * np.cos(((2 * y + 1) * v_ * np.pi) / (2 * n))

            dst[v_, u_] = C(u_, n) * C(v_, n) * np.sum(mask)

    return np.round(dst)


def my_zigzag_encoding(block, block_size=8):
    ######################################
    # TODO                               #
    # my_zigzag_encoding 완성             #
    ######################################
    zigzag_value = list()
    pos = sort_pos.copy()

    while pos:
        element = pos.pop(0)
        row, col = element[1], element[2]
        zigzag_value.append(block[row][col])
    zigzag_value = np.array(zigzag_value)
    index = block_size ** 2 - 1
    while zigzag_value[index] == 0:
        if index == 0:
            break;
        index -= 1
    result = zigzag_value[0:index + 1]
    zigzag_encode = np.append(result, 'EOB')
    return zigzag_encode


def my_zigzag_decoding(block, block_size=8):
    ######################################
    # TODO                               #
    # my_zigzag_decoding 완성             #
    ######################################

    pos = sort_pos.copy()

    zigzag_decode = np.zeros((block_size, block_size))
    decoded = np.delete(block, len(block) - 1)

    index = 0

    while index < len(decoded):
        element = pos.pop(0)
        row, col = element[1], element[2]
        zigzag_decode[row][col] = decoded[index]
        index += 1

    return zigzag_decode





def DCT_inv(block, n=8):
    ###################################################
    # TODO                                            #
    # DCT_inv 완성                                     #
    # DCT_inv 는 DCT와 다름.                            #
    ###################################################
    dst = np.zeros(block.shape)

    v, u = dst.shape
    y, x = np.mgrid[0:u, 0:v]

    C1 = C_inv(y, n=n)
    C2 = C_inv(x, n=n)

    for v_ in range(v):
        for u_ in range(u):
            temp = block * np.cos(((2 * u_ + 1) * x * np.pi) / (2 * n)) * np.cos(((2 * v_ + 1) * y * np.pi) / (2 * n))
            dst[v_, u_] = np.sum(C1 * C2 * temp)
    dst = np.clip(dst, -128, 127)
    return np.round(dst)


def block2img(blocks, src_shape, n=8):
    ###################################################
    # TODO                                            #
    # block2img 완성                                   #
    # 복구한 block들을 image로 만들기                     #
    ###################################################
    (h, w) = src_shape
    p_h = h
    p_w = w
    if h % n != 0:
        p_h = h + (n - h % n)
    if w % n != 0:
        p_w = w + (n - w % n)
    dst = np.zeros((p_h, p_w))
    index = 0
    for i in range(p_h // n):
        for j in range(p_w // n):
            dst[i * n:(i + 1) * n, j * n:(j + 1) * n] = blocks[index]
            index += 1
    return dst[:h, :w].astype(np.uint8)


def Encoding(src, n=8, scale_factor=1):
    #################################################################################################
    # TODO                                                                                          #
    # Encoding 완성                                                                                  #
    # Encoding 함수를 참고용으로 첨부하긴 했는데 수정해서 사용하실 분은 수정하셔도 전혀 상관 없습니다.              #
    #################################################################################################
    print('<start Encoding>')
    # img -> blocks
    blocks = img2block(src, n=n)
    print("block = \n", src[150:158, 89:97])

    # subtract 128
    blocks -= 128
    b = np.double(src[150:158, 89:97]) - 128
    print("b = \n", b)

    # DCT
    blocks_dct = []
    for block in blocks:
        blocks_dct.append(DCT(block, n=n))
    blocks_dct = np.array(blocks_dct)

    # print DCT results
    bd = DCT(b, n=8)
    print("bd = \n", bd)

    # Quantization + thresholding
    Q = Quantization_Luminance(scale_factor)
    QnT = np.round(blocks_dct / Q)
    # print Quantization results
    bq = np.round(bd / Q)
    print("bq = \n", bq)

    # zigzag scanning
    zz = []
    for i in range(len(QnT)):
        zz.append(my_zigzag_encoding(QnT[i], block_size=n))

    return zz, src.shape, bq


def Decoding(zigzag, src_shape, bq, n=8, scale_factor=1):
    #################################################################################################
    # TODO                                                                                          #
    # Decoding 완성                                                                                  #
    # Decoding 함수를 참고용으로 첨부하긴 했는데 수정해서 사용하실 분은 수정하셔도 전혀 상관 없습니다.              #
    #################################################################################################
    print('<start Decoding>')

    # zigzag scanning
    blocks = []
    for i in range(len(zigzag)):
        blocks.append(my_zigzag_decoding(zigzag[i], block_size=n))
    blocks = np.array(blocks)

    # Denormalizing
    Q = Quantization_Luminance(scale_factor=scale_factor)
    blocks = blocks * Q
    # print results Block * Q
    bq2 = bq * Q
    print("bq2 = \n", bq2)

    # inverse DCT
    blocks_idct = []
    for block in blocks:
        blocks_idct.append(DCT_inv(block, n=n))
    blocks_idct = np.array(blocks_idct)

    # print IDCT results
    bd2 = DCT_inv(bq2, n=8)
    print("bd2 = \n", bd2)

    # add 128
    blocks_idct += 128

    # print block value
    b2 = bd2 + 128
    print("b2 = \n", b2)

    # block -> img
    dst = block2img(blocks_idct, src_shape=src_shape, n=n)

    return dst, b2


def main():
    scale_factor = 1
    start = time.time()
    # src = cv2.imread('../imgs/Lenna.png', cv2.IMREAD_GRAYSCALE)
    src = cv2.imread('caribou.tif', cv2.IMREAD_GRAYSCALE)

    comp, src_shape, bq = Encoding(src, n=8, scale_factor=scale_factor)
    np.save('comp.npy', comp)
    np.save('src_shape.npy', src_shape)
    # print(comp)
    comp = np.load('comp.npy', allow_pickle=True)
    src_shape = np.load('src_shape.npy')
    recover_img, b2 = Decoding(comp, src_shape, bq, n=8, scale_factor=scale_factor)
    print("scale_factor : ", scale_factor, "differences between original and reconstructed = \n",
          src[150:158, 89:97] - b2)
    # print(recover_img)
    total_time = time.time() - start
    #
    print('time : ', total_time)
    if total_time > 12:
        print('감점 예정입니다.')
    print(recover_img.shape)
    cv2.imshow('recover img', recover_img)
    cv2.waitKey()
    cv2.destroyAllWindows()


if __name__ == '__main__':
    main()
