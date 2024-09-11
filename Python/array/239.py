from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue = []  # 队列存下标，且保证对应数组的值递减
        for i in range(k):
            # 若新加进来的数大于它左边的数，那就把左边的数移除
            while queue and nums[i] >= nums[queue[-1]]:
                queue.pop()
            queue.append(i)

        res = [nums[queue[0]]]
        for i in range(k, len(nums)):
            # 若新加进来的数大于它左边的数，那就把左边的数移除
            while queue and nums[i] >= nums[queue[-1]]:
                queue.pop()
            queue.append(i)
            # 若左边的下标不属于现在的窗口,也移除
            if queue[0] <= i - k:
                queue.pop(0)
            res.append(nums[queue[0]])
        return res


if __name__ == '__main__':
    arr = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    print(Solution().maxSlidingWindow(arr, k))
