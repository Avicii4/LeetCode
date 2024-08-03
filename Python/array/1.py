from typing import List
from collections import defaultdict


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 先全部存进map，然后查
        map = defaultdict(list)
        for i in range(len(nums)):
            map[nums[i]] += [i]

        for key in map:
            if key << 1 == target and len(map[key]) > 1:
                return map[key][:2]
            if target - key in map:
                a, b = map[key][0], map[target - key][0]
                if a != b:
                    return [a, b]

    def twoSum_2(self, nums: List[int], target: int) -> List[int]:
        map = dict()
        for i, num in enumerate(nums):
            k = target - num
            if k in map:
                return [map[k], i]
            else:
                map[num] = i


if __name__ == '__main__':
    arr = [3, 3, 3]
    tar = 6
    print(Solution().twoSum(arr, tar))
