from ListNode import ListNode, output
from typing import Optional


class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        new_head = ListNode(-1)
        pre, n1, n2 = new_head, head, head.next
        res = head.next
        while True:
            next = n2.next
            pre.next = n2
            n2.next = n1
            n1.next = next
            if next is None or next.next is None:
                break
            else:
                pre, n1, n2 = n1, next, next.next
        new_head.next = None
        return res


if __name__ == '__main__':
    n1, n2, n3, n4, n5, n6, n7 = (ListNode(-10), ListNode(-9), ListNode(-6),
                                  ListNode(-4), ListNode(-1), ListNode(9), ListNode(9))
    # n1.next, n2.next, n3.next, n4.next, n5.next, n6.next = n2, n3, n4, n5, n6, n7
    n1.next = n2
    output(n1)

    head = Solution().swapPairs(n1)
    output(head)
