from ListNode import ListNode
from typing import Optional


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if head is None or head.next is None or head.next.next is None:
            return False
        slow = head
        fast = head.next
        while fast.next and fast.next.next:
            if slow != fast:
                slow = slow.next
                fast = fast.next.next
            else:
                return True
        return False


if __name__ == '__main__':
    n1, n2, n3, n4, n5 = ListNode(1), ListNode(2), ListNode(3), ListNode(4), ListNode(5)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next=n5
    n5.next = n2
    print(Solution().hasCycle(n1))
