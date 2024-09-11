from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [1 for _ in range(n)]
        res = 0
        for i in range(1, n):
            for j in range(0, i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[j] + 1, dp[i])
            res = max(res, dp[i])
        return res


if __name__ == '__main__':
    arr = [10, 9, 2, 5, 3, 7, 101, 18]
    print(Solution().lengthOfLIS(arr))
