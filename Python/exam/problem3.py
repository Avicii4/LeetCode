class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getMethod(self, head: ListNode, colors: str) -> int:
        mod = 10 ** 9 + 7
        cur = head
        white_even, white_odd = 0, 0
        cur_sum = 0
        for i in range(len(colors)):
            if colors[i] == 'R':
                cur_sum += cur.val
            else:
                if cur.val % 2:
                    white_odd += 1
                else:
                    white_even += 1
            cur = cur.next

        return (2 ** (white_odd - 1 + white_even)) % mod
