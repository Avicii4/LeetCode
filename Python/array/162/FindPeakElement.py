from typing import List


class Solution:
    """
    二分法每次拆分出一个子结构，其基本构成是：
      /    .  . . .  .  \
     /                   \
    /                     \
    也就是前两个位置是升的，最后两个位置是降的，这种子结构里面一定含有局部最大值
    """
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return nums.index(max(nums))
        left, right = 0, len(nums) - 1
        while left < right:
            if nums[left] > nums[left + 1]:
                return left
            if nums[right] > nums[right - 1]:
                return right
            mid = (left + right) >> 1
            if nums[mid] < nums[mid - 1]:
                right = mid
            elif nums[mid] < nums[mid + 1]:
                left = mid
            else:
                return mid
        return -1


if __name__ == '__main__':
    # arr = [1, 2, 1, 3, 5, 6, 4]
    arr=[1,2]
    print(Solution().findPeakElement(arr))
