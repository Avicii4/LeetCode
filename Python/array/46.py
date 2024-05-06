from typing import List


class Solution:
    """
    不含重复数字的数组,得到全排列
    """

    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        n = len(nums)
        visited = [False for _ in range(n)]

        def process(idx, tmp):
            if idx == n:
                res.append(tmp)
                return
            for i in range(n):
                if not visited[i]:
                    visited[i] = True
                    process(idx + 1, tmp + [nums[i]])
                    visited[i] = False

        process(0, [])
        return res


if __name__ == '__main__':
    nums = [1, 3, 5]
    print(Solution().permute(nums))
