from lintcode import ListNode


class MyQueue:

    def __init__(self):
        self.head, self.rear = None, None

    """
    入队是放在链表尾部
    @param: item: An integer
    @return: nothing
    """

    def enqueue(self, item):
        # write your code here
        new_node = ListNode(item)
        if not self.head:
            self.head = new_node
            self.rear = new_node
        else:
            self.rear.next = new_node
            self.rear = new_node

    """
    出队是放在链表头部
    @return: An integer
    """

    def dequeue(self):
        # write your code here
        if not self.head:
            return -1
        res = self.head.val
        if self.head == self.rear:
            self.head = self.rear = None
        else:
            p = self.head.next
            self.head.next = None
            self.head = p
        return res


if __name__ == '__main__':
    head = None
    queue = MyQueue()
    print(queue.dequeue())
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    print(queue.dequeue())
    print(queue.dequeue())
    print(queue.dequeue())
    queue.enqueue(4)
    print(queue.dequeue())
