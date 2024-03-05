from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left_idx = self.binSearch(nums, target, True)
        right_idx = self.binSearch(nums, target, False)
        return [left_idx, right_idx]

    def binSearch(self, nums, target, left_bias):
        # left_bias为True时，我们要找左边界，否则要找右边界
        left, right = 0, len(nums) - 1
        i = -1
        while left <= right:
            mid = (left + right) >> 1
            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                i = mid
                # 即便找到目标值，我们依然要继续往下搜索
                if left_bias:
                    right = mid - 1
                else:
                    left = mid + 1
        return i
