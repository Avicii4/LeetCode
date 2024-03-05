from ListNode import ListNode, output
from typing import Optional


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        p, q = head, head
        new_head = ListNode(-1)
        pre=new_head
        pre.next = head
        while n > 0:
            q = q.next
            n -= 1
        while q:
            pre, p, q = pre.next, p.next, q.next

        pre.next = p.next
        res=new_head.next
        new_head.next=None
        return res


if __name__ == '__main__':
    n1, n2, n3, n4, n5, n6, n7 = (ListNode(1), ListNode(2), ListNode(3),
                                  ListNode(4), ListNode(5), ListNode(6), ListNode(7))
    n1.next, n2.next, n3.next, n4.next, n5.next, n6.next = n2, n3, n4, n5, n6, n7
    output(n1)
    output(Solution().removeNthFromEnd(n1, 7))
