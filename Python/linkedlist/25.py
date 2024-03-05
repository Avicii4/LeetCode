from ListNode import ListNode, output
from typing import Optional


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        newhead = ListNode(-1)
        newhead.next = head
        pre, p, q = newhead, head, head
        while q:
            for _ in range(k - 1):
                q = q.next
                if not q: break
            if not q: break
            next = q.next
            h, t = self.reverse(p, q)
            pre.next = h
            t.next = next
            pre, p, q = t, next, next

        res = newhead.next
        newhead.next = None
        return res

    def reverse(self, head, tail):
        pre, next = None, None
        p = head
        tail.next = None
        while p:
            next = p.next
            p.next = pre
            pre = p
            p = next
        head.next = None
        return tail, head


if __name__ == '__main__':
    n1, n2, n3, n4, n5, n6, n7 = (ListNode(1), ListNode(2), ListNode(3),
                                  ListNode(4), ListNode(5), ListNode(6), ListNode(7))
    n1.next, n2.next, n3.next, n4.next, n5.next, n6.next = n2, n3, n4, n5, n6, n7
    output(n1)
    res = Solution().reverseKGroup(n1, 4)
    output(res)
