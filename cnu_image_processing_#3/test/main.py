import numpy as np

import matplotlib.pyplot as plt

if __name__ == '__main__':
    arr = np.array([3,2,1,1,2,1])
    x = np.arange(len(arr))

    plt.bar(x,arr,color = 'g')
    plt.title('test')
    plt.xlabel('x')
    plt.ylabel('y')
    plt.show()

