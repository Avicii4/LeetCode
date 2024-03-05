from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) >> 1
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1


if __name__ == '__main__':
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    assert Solution().search(arr, 5) == 4
    assert Solution().search(arr, 10) == -1
    assert Solution().search(arr, 1) == 0
    assert Solution().search(arr, 9) == 8

    # 边界测试
    assert Solution().search([], 5) == -1  # 空数组
    assert Solution().search([5], 5) == 0  # 只有一个元素的数组
    assert Solution().search([1, 2, 3], 4) == -1  # 未找到的情况

    # 大规模测试
    large_arr = list(range(10000))
    assert Solution().search(large_arr, 9999) == 9999

    print("所有测试通过")
