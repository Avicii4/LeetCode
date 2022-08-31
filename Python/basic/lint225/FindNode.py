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
    @param head: the head of linked list.
    @param val: An integer.
    @return: a linked node or null.
    """

    def find_node(self, head: ListNode, val: int) -> ListNode:
        # write your code here
        while head is not None:
            if head.val == val:
                return head
            else:
                head = head.next
        return None
