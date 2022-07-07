import cv2
import numpy as np

def my_bilinear(src, scale):
    (h, w) = src.shape
    # 0.5를 더해주는 이유는 반올림을 위함이다.
    h_dst = int(h * scale + 0.5)
    w_dst = int(w * scale + 0.5)

    dst = np.zeros((h_dst, w_dst), np.uint8)

    ############################################
    # TODO                                     #
    # my_bilinear 완성                          #
    ############################################
    for row in range(h_dst):
        for col in range(w_dst):
            #compute the location
            x_s = int(row / scale)
            y_s = int(col / scale)

            s_f = row / scale - x_s
            t_f = col / scale - y_s

            if x_s + 1 < w and y_s + 1 < h:

                #scale test
                #f_m_n = (1 - scale) * (1 - scale) * src[x_s, y_s]
                #f_m_n1 = scale * (1-scale) * src[x_s, y_s + 1]
                #f_m1_n = (1 - scale) * scale * src[x_s+1, y_s]
                #f_m1_n1 = scale * scale * src[x_s + 1, y_s + 1]


                f_m_n = (1 - s_f) * (1 - t_f) * src[x_s, y_s]
                f_m_n1 = s_f * (1-t_f) * src[x_s, y_s + 1]
                f_m1_n = (1 - s_f) * t_f * src[x_s+1, y_s]
                f_m1_n1 = s_f * t_f * src[x_s + 1, y_s + 1]

                dst[row, col] = f_m_n + f_m_n1 + f_m1_n + f_m1_n1
            else:
                dst[row, col] = src[x_s, y_s]

    return dst

if __name__ == '__main__':
    img = cv2.imread('Lenna.png', cv2.IMREAD_GRAYSCALE)

    down_cv2 = cv2.resize(img, dsize=(0,0), fx=0.25, fy=0.25, interpolation=cv2.INTER_LINEAR)
    down_up_cv2 = cv2.resize(down_cv2, dsize=(0, 0), fx=4.0, fy=4.0, interpolation=cv2.INTER_LINEAR)

    down_my = my_bilinear(img, scale=0.25)
    down_up_my = my_bilinear(down_my, scale=4.0)

    cv2.imshow('original image', img)
    cv2.imshow('down_cv2_n image', down_cv2)
    cv2.imshow('down_up_cv2_n', down_up_cv2)
    cv2.imshow('down_my', down_my)
    cv2.imshow('down_up_my', down_up_my)

    cv2.waitKey(0)
    cv2.destroyAllWindows()

