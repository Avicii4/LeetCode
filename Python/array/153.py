from typing import List

"""
左、中、右三个位置的值相比较，有以下几种情况：
1. 左值 < 中值, 中值 < 右值 ：没有旋转，最小值在最左边，可以收缩右边界
2. 左值 > 中值, 中值 < 右值 ：有旋转，最小值在左半边，可以收缩右边界
3. 左值 < 中值, 中值 > 右值 ：有旋转，最小值在右半边，可以收缩左边界
其中可把1.2合并
注意while循环到最后只会剩两个数字，即left == mid == right - 1，无论如何
nums[left]都保存着最小值
"""


class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid
        return nums[left]


if __name__ == '__main__':
    arr = [2, 3, 4, 5, 1]
    print(Solution().findMin(arr))
