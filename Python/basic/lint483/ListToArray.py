from typing import (
    List,
)
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
    @return: An integer list
    """

    def to_array_list(self, head: ListNode) -> List[int]:
        # write your code here
        res = []
        while head is not None:
            res.append(head.val)
            head = head.next
        return res


if __name__ == '__main__':
    sol = Solution()
    lst = ListNode(1)
    head = lst
    lst.next = ListNode(3)
    lst = lst.next
    lst.next = ListNode(5)
    print(sol.to_array_list(head))
