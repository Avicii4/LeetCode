from ListNode import ListNode, output
from typing import Optional


class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        tmp_head = ListNode()
        tmp_head.next = head
        ordered_end = head
        while ordered_end.next is not None:
            cur_node = ordered_end.next
            ordered_end.next = ordered_end.next.next
            pre, p = tmp_head, head
            while p is not None:
                if p.val < cur_node.val:
                    pre, p = p, p.next
                else:
                    pre.next = cur_node
                    cur_node.next = p


if __name__ == '__main__':
    node_arr = [ListNode(x) for x in range(10)]
    for i in range(9):
        node_arr[i].next = node_arr[i + 1]
    node_arr[4].val=12
    node_arr[8].val=3
    output(node_arr[0])
    Solution().insertionSortList(node_arr[0])
    output(node_arr[0])

