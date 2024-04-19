import heapq


class Solution:
    def maxLen(self, s: str, k: int) -> int:
        heap = []
        cur_len = 0
        for i in range(len(s)):
            if s[i] == '0':
                if cur_len > 0:
                    heapq.heappush(heap, -cur_len)
                    cur_len = 0
            if s[i] == '1':
                cur_len += 1
        if cur_len > 0:
            heapq.heappush(heap, -cur_len)
        for _ in range(k):
            if len(heap) == 0:
                return 0
            pop_val = -heapq.heappop(heap)
            if pop_val == 1:
                continue
            elif pop_val == 2:
                heapq.heappush(heap, -1)
                continue
            elif pop_val % 2 == 1:  # 弹出的是奇数
                heapq.heappush(heap, -((pop_val - 1) // 2))
                heapq.heappush(heap, -((pop_val - 1) // 2))
            else:  # 弹出的是偶数
                heapq.heappush(heap, -(pop_val // 2))
                heapq.heappush(heap, -((pop_val - 2) // 2))
        if len(heap) == 0:
            return 0
        return -heapq.heappop(heap)


if __name__ == '__main__':
    s = "111111010011111"
    k = 2
    print(Solution().maxLen(s, k))
