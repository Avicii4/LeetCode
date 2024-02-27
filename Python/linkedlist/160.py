from typing import Optional

from ListNode import ListNode


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        if headA is None or headB is None:
            return None
        p, q = headA, headB
        n = 0
        while p.next:
            n += 1
            p = p.next
        while q.next:
            n -= 1
            q = q.next
        if p != q:
            return None
        if n >= 0:
            p, q = headA, headB
        else:
            p, q = headB, headA
        n=abs(n)
        while n > 0:
            n -= 1
            p = p.next
        while p != q:
            p, q = p.next, q.next
        return p


if __name__ == '__main__':
    n1,n2,n3,n4,n5,n6=ListNode(1),ListNode(2),ListNode(3),ListNode(4),ListNode(5),ListNode(6)
    n1.next=n2
    n2.next=n3
    n3.next=n4
    n5.next=n6
    n6.next=n2
    print(Solution().getIntersectionNode(n1,n5).val)
