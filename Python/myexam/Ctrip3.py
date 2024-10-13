import math
from functools import lru_cache


class Solution:
    mem = {}

    def max_gcd(self, m, arr):
        res = [-1]
        self.dfs(arr, m, 0, 0, res)
        return res[0]

    def dfs(self, arr, m, start, cur_gcd, result):
        if (m, start) in self.mem:
            return self.mem[(m, start)]

        if m == 1:
            last_gcd = self.subarrgcd(tuple(arr), start, len(arr) - 1)
            result[0] = max(result[0], cur_gcd + last_gcd)
            self.mem[(m, start)] = result[0]
            return
        for i in range(start, len(arr) - m + 1):
            curr = self.subarrgcd(tuple(arr), start, i)
            self.dfs(arr, m - 1, i + 1, curr + cur_gcd, result)

    @lru_cache(None)
    def subarrgcd(self, arr, start, end):
        res = arr[start]
        for i in range(start + 1, end + 1):
            res = math.gcd(res, arr[i])
        return res


n, m = map(int, input().split())
a = list(map(int, input().split()))
print(Solution().max_gcd(m, a))
