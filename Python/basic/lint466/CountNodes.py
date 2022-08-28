from lintcode import (
    ListNode,
)

"""
Definition of ListNode:
class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""


class Solution:
    """
    @param head: the first node of linked list.
    @return: An integer
    """

    def count_nodes(self, head: ListNode) -> int:
        cnt = 0
        while head is not None:
            cnt += 1
            head = head.next
        return cnt


if __name__ == '__main__':
    sol = Solution()
    lst = ListNode(1)
    head = lst
    lst.next = ListNode(3)
    lst = lst.next
    lst.next = ListNode(5)
    print(sol.count_nodes(head))
