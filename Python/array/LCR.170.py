from typing import List

"""
求数组中逆序对的个数
"""


class Solution:
    def reversePairs(self, record: List[int]) -> int:
        if len(record) < 2:
            return 0
        return self.process(record, 0, len(record) - 1)

    def process(self, record, left, right):
        if left == right:
            return 0
        mid = (left + right) >> 1
        return (self.process(record, left, mid) +
                self.process(record, mid + 1, right) +
                self.merge_both(record, left, mid, right))

    def merge_both(self, record, left, mid, right):
        help = [0 for _ in range(right - left + 1)]
        p, q = left, mid + 1
        cur = 0
        reverse_pair = 0
        while p <= mid and q <= right:
            if record[p] > record[q]:
                reverse_pair += (right - q + 1)  # 右边总共有right-q+1个数比record[p]小
                help[cur] = record[p]
                cur += 1
                p += 1
            else:
                help[cur] = record[q]
                cur += 1
                q += 1
        while p <= mid:
            help[cur] = record[p]
            cur += 1
            p += 1
        while q <= right:
            help[cur] = record[q]
            cur += 1
            q += 1
        for i in range(len(help)):
            record[left + i] = help[i]
        return reverse_pair


if __name__ == '__main__':
    r = [9, 7, 5, 4, 6]
    print(Solution().reversePairs(r))
