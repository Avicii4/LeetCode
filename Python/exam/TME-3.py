from typing import List


class Solution:
    def min_value(self, nums: List[int], m: int) -> int:
        for num_to_insert in range(1, m + 1):
            min_w = float('inf')
            idx = 0

            for i in range(len(nums)):
                new_arr = nums[:i] + [num_to_insert] + nums[i:]
                new_w = self.get_weight(new_arr)
                if new_w < min_w:
                    min_w = new_w
                    idx = i

            nums.insert(idx, num_to_insert)
        return self.get_weight(nums)

    def get_weight(self, arr):
        return sum(abs(arr[i] - arr[i + 1]) for i in range(len(arr) - 1))
