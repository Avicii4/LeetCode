from typing import List


class Solution:
    def find_median(self, array1: List[float], array2: List[float]) -> float:
        if len(array2) < len(array1):
            array1, array2 = array2, array1

        m, n = len(array1), len(array2)
        half_len = (m + n) // 2

        l, r = 0, m
        while l <= r:
            i = (l + r) // 2
            j = half_len - i
            arr1_left_max = float('-inf') if i == 0 else array1[i - 1]
            arr1_right_min = float('inf') if i == m else array1[i]
            arr2_left_max = float('-inf') if j == 0 else array2[j - 1]
            arr2_right_min = float('inf') if j == n else array2[j]

            if arr1_left_max <= arr2_right_min and arr2_left_max <= arr1_right_min:
                if (m + n) % 2 == 1:
                    return min(arr1_right_min, arr2_right_min)
                else:
                    a = max(arr1_left_max, arr2_left_max)
                    b = min(arr1_right_min, arr2_right_min)
                    return min(a, b)
            elif arr1_left_max > arr2_right_min:
                r = i - 1
            else:
                l = i + 1
