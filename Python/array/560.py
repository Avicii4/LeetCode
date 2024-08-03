from typing import List


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res, cur_sum = 0, 0
        map = {0: 1}
        for num in nums:
            cur_sum += num
            interval = cur_sum - k
            res += map.get(interval, 0)
            map[cur_sum] = map.get(cur_sum, 0) + 1

        return res


if __name__ == '__main__':
    arr = [1, 1, 1, 1]
    k = 2
    print(Solution().subarraySum(arr, k))
