from ListNode import ListNode, output
from typing import Optional


class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        if head.next.next is None:
            return head.next

        slow = head.next
        fast = head.next
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next

        return slow


if __name__ == '__main__':
    node1 = ListNode(1)
    node2 = ListNode(2)
    # node3 = ListNode(3)
    node1.next = node2
    output(node1)
    print(Solution().middleNode(node1).val)
