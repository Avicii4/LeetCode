from ListNode import ListNode, output
from typing import Optional


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if list1 is None:
            return list2
        if list2 is None:
            return list1
        if list1.val <= list2.val:
            p, q = list1, list2
            res = list1
        else:
            p, q = list2, list1
            res = list2
        while p and q:
            if p.val <= q.val:
                pre_p = p
                p = p.next
            else:
                qnext = q.next
                pre_p.next = q
                q.next = p
                pre_p=q
                q = qnext
        if q:
            pre_p.next = q
        return res


if __name__ == '__main__':
    n1, n2, n3, n4, n5, n6, n7 = ListNode(-10), ListNode(-9), ListNode(-6), ListNode(-4), ListNode(-1), ListNode(
        9), ListNode(9)
    m1, m2, m3, m4, m5, m6 = ListNode(-5), ListNode(-3), ListNode(0), ListNode(7), ListNode(8), ListNode(8)
    n1.next, n2.next, n3.next, n4.next, n5.next, n6.next = n2, n3, n4, n5, n6, n7
    m1.next, m2.next, m3.next, m4.next, m5.next = m2, m3, m4, m5, m6

    output(n1)
    output(m1)

    merge_head = Solution().mergeTwoLists(n1, m1)
    output(merge_head)
