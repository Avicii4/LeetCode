import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        q = []
        for num in nums:
            if len(q) < k:
                heapq.heappush(q,num)
            else:
                if num > q[0]:
                    heapq.heappop(q)
                    heapq.heappush(q, num)
        return q[0]


if __name__ == '__main__':
    arr = [3,2,1,5,6,4]
    print(Solution().findKthLargest(arr,3))