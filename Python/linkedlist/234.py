from ListNode import ListNode
from typing import Optional


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return True

        # 寻找中点（偶数个节点的话就是找上中点）
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # 将后半部分反转
        p = slow.next
        pre, next = None, None
        while p:
            next = p.next
            p.next = pre
            pre = p
            p = next
        slow.next = None

        # 前后比较
        res = True
        second_half = pre
        while head and pre:
            if head.val != pre.val:
                res = False
            head = head.next
            pre = pre.next

        # 复原链表
        pre, next = None, None
        while second_half:
            next = second_half.next
            second_half.next = pre
            pre = second_half
            second_half = next
        return res


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(2)
    head.next.next.next.next = ListNode(1)
    print(Solution().isPalindrome(head))
