from ListNode import ListNode, output
from typing import Optional, List
from queue import PriorityQueue as PQ


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        pointers = []
        for lst in lists:
            if lst:
                p = lst
                pointers.append(p)
        start = dummy = ListNode()
        while len(pointers) > 0:
            values = []
            for p in pointers:
                values.append(p.val)
            min_index = values.index(min(values))
            start.next = pointers[min_index]
            start = start.next
            pointers[min_index] = pointers[min_index].next
            if not pointers[min_index]:
                pointers.pop(min_index)
        return dummy.next

    def mergeKLists_2(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        """
        用优先队列，保存每个即将要被排序的节点
        但是注意，Python不支持自定义比较器，这个方法题用Java好写
        """
        if not lists:
            return None
        q = PQ()
        for lst in lists:
            if lst:
                q.put(lst)
        start = dummy = ListNode()
        while q.qsize() > 0:
            pop_node = q.get()
            start.next = pop_node
            start = start.next
            if pop_node.next:
                q.put(pop_node.next)
        return dummy.next


if __name__ == '__main__':
    # 创建第一个链表: 1 -> 3 -> 10
    linked_list1 = ListNode(1)
    linked_list1.next = ListNode(3)
    linked_list1.next.next = ListNode(10)

    # 创建第二个链表: 2 -> 7
    linked_list2 = ListNode(2)
    linked_list2.next = ListNode(7)

    # 创建第三个链表: 5 -> 6 -> 11 -> 20
    linked_list3 = ListNode(5)
    linked_list3.next = ListNode(6)
    linked_list3.next.next = ListNode(11)
    linked_list3.next.next.next = ListNode(20)

    l = [linked_list1, linked_list2, linked_list3]
    for i in l:
        output(i)
    head = Solution().mergeKLists(l)
    output(head)
