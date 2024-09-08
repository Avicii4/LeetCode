from itertools import product
import numpy as np


def counter(arr, k):
    res = 0
    for mat in product(range(4), repeat=9):
        my_res = []
        my_res.append(mat[0]^mat[1]^mat[2])
        my_res.append(mat[3]^mat[4]^mat[5])
        my_res.append(mat[6]^mat[7]^mat[8])
        my_res.append(mat[0]^mat[3]^mat[6])
        my_res.append(mat[1]^mat[4]^mat[7])
        my_res.append(mat[2]^mat[5]^mat[8])

        t = 0
        for i in range(6):
            if my_res[i] == arr[i]:
                t += 1
        if t >= k:
            res += 1
    return res


def xor_sum(lst):
    res = 0
    for num in lst:
        res ^= num
    return res


arr = list(map(int, input().split()))
k = int(input())
print(counter(arr, k))
