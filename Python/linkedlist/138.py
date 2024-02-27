from typing import Optional


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None
        cur = head
        while cur:
            next = cur.next
            copy_node = Node(cur.val)
            cur.next = copy_node
            copy_node.next = next
            cur = next
        cur = head
        while cur:
            next = cur.next.next
            cur_copy = cur.next
            cur_copy.random = cur.random.next if cur.random else None
            cur = next
        cur = head
        res = head.next
        while cur:
            next = cur.next
            cur.next = next.next if next else None
            cur = next
        return res


if __name__ == '__main__':
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)
    n1.next, n2.next = n2, n3
    n1.random, n2.random, n3.random = n3, n1, None
    newhead = Solution().copyRandomList(n1)
    print(newhead)
