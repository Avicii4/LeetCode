from ListNode import ListNode, output
from typing import Optional


class Solution:
    def reverseBetween(self, head: Optional[ListNode],
                       left: int, right: int) -> Optional[ListNode]:
        # 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        dummy_node = ListNode(-1)
        dummy_node.next = head
        pre = dummy_node
        for _ in range(left - 1):
            pre = pre.next

        right_node = pre
        for _ in range(right - left + 1):
            # 走到要反转的最后一个节点上
            right_node = right_node.next
        left_node = pre.next  # 开始要反转的节点
        succ = right_node.next  # 反转子段之后的那一个节点
        # 注意！切断要反转的那一块
        pre.next = None
        right_node.next = None
        # 常规的反转操作
        help_pre, help_next = None, None
        cur = left_node
        while cur is not None:
            help_next = cur.next
            cur.next = help_pre
            help_pre = cur
            cur = help_next
        pre.next = right_node
        left_node.next = succ
        return dummy_node.next


if __name__ == '__main__':
    node_arr = [ListNode(x) for x in range(10)]
    for i in range(9):
        node_arr[i].next = node_arr[i + 1]

    # Solution().reverseBetween(node_arr[0], 2, 5)
    # output(node_arr[0])
    lst = ListNode(5)
    lst.next = ListNode(6)
    Solution().reverseBetween(lst, 1, 2)
    output(lst)
