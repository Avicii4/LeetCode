from ListNode import ListNode, output
from typing import Optional

"""
这题没必要写常数空间消耗的解法，递归的归并即可
注意找的中点是前中点，merge_both第一次写错了
"""
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        left = head
        mid = self.get_mid(head)
        tmp = mid.next
        mid.next = None
        right = tmp
        left = self.sortList(left)
        right = self.sortList(right)
        return self.merge_both(left, right)

    def get_mid(self, head):
        if not head or not head.next:
            return head
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    def merge_both(self, left, right):
        start = dummy_head = ListNode()
        while left and right:
            if left.val <= right.val:
                start.next = left
                left = left.next
            else:
                start.next = right
                right = right.next
            start = start.next
        if left:
            start.next = left
        if right:
            start.next = right
        return dummy_head.next


if __name__ == '__main__':
    n1, n2, n3, n4, n5 = ListNode(4), ListNode(5), ListNode(3), ListNode(2), ListNode(1)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next=ListNode(6)
    output(n1)
    new = Solution().sortList(n1)
    output(new)
