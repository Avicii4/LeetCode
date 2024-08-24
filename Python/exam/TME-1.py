class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def merge(self, a: ListNode) -> int:
        res = 0
        cur = a
        while cur and cur.next:
            if (cur.val == 0 and cur.next.val == 0) or (cur.val != 0 and cur.next.val != 0):
                cur.val = max(cur.val, cur.next.val)
                cur.next = cur.next.next
                res += 1
            else:
                cur = cur.next

        return res


n1 = ListNode(0)
n1.next = ListNode(1)
n1.next.next = ListNode(0)
print(Solution().merge(n1))
