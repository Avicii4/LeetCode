from ListNode import ListNode
from typing import Optional


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None or head.next.next is None:
            return None
        # 这里的初始设置要注意
        slow = head.next
        fast = head.next.next
        while fast.next and fast.next.next:
            if slow != fast:
                slow, fast = slow.next, fast.next.next
            else:
                break
        if slow != fast:
            return None
        fast = head
        while slow != fast:
            slow, fast = slow.next, fast.next
        return slow


if __name__ == '__main__':
    n1, n2, n3, n4, n5 = ListNode(1), ListNode(2), ListNode(3), ListNode(4), ListNode(5)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n2
    print(Solution().detectCycle(n1))
