from typing import List


class Solution:
    """
    山脉数组，思路是二分
    """
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        left, right = 0, len(arr) - 1
        while left < right:
            mid = (left + right) >> 1
            if arr[mid] > arr[mid + 1] and arr[mid] > arr[mid - 1]:
                return mid
            elif arr[mid] < arr[mid + 1]:
                left = mid - 1
            else:
                right = mid + 1
        return left

    def other(self, arr: List[int]) -> int:
        n = len(arr)
        ans = -1
        for i in range(n):
            if arr[i] > arr[i + 1]:
                ans = i
                break
        return ans


if __name__ == '__main__':
    arr = [10]
    print(Solution().peakIndexInMountainArray(arr))
