from typing import List


class Solution:
    def search_1(self, nums: List[int], target: int) -> int:
        # 先找换分区域,参考LeetCode 153
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) >> 1
            if nums[mid] < nums[right]:
                right = mid
            else:
                left = mid + 1
        split_idx = left
        # 在分头查找
        if target <= nums[-1]:
            left, right = split_idx, len(nums) - 1
        elif target >= nums[0]:
            left, right = 0, split_idx - 1
        else:
            return -1
        while left <= right:
            mid = (left + right) >> 1
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1

    def search_2(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) >> 1
            if nums[mid] == target:
                return mid
            elif nums[0] <= nums[mid]:  # 左半边有序
                if nums[0] <= target < nums[mid]:  # 在左半边范围内
                    right = mid - 1
                else:  # 否则去找右半边
                    left = mid + 1
            else:  # 左半边无序的话，右半边肯定有序
                if nums[mid] < target <= nums[-1]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1


if __name__ == '__main__':
    arr = [8, 1, 2, 3, 4, 5]
    t = 1
    print(Solution().search_2(arr, t))
