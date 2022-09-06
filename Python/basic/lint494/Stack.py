from collections import deque

class Stack:

    def __init__(self):
        self.queue_1, self.queue_2 = deque(), deque()

    """
    @param: x: An integer
    @return: nothing
    """
    def push(self, x):
        # write your code here
        self.queue_1.append(x)

    """
    @return: nothing
    """

    def pop(self):
        # write your code here
        while len(self.queue_1) > 1:
            self.queue_2.append(self.queue_1.popleft())
        self.queue_1, self.queue_2 = self.queue_2, self.queue_1
        self.queue_2.popleft()

    """
    @return: An integer
    """

    def top(self):
        # write your code here
        while len(self.queue_1) > 1:
            self.queue_2.append(self.queue_1.popleft())
        p = self.queue_1.popleft()
        self.queue_2.append(p)
        self.queue_1, self.queue_2 = self.queue_2, self.queue_1
        return p


    """
    @return: True if the stack is empty
    """

    def isEmpty(self):
        # write your code here
        return not self.queue_1


if __name__ == '__main__':
    stack = Stack()
    # stack.push(1)
    # stack.pop()
    # stack.push(2)
    print(stack.isEmpty())
    # print(stack.top())
    # stack.pop()
    # print(stack.isEmpty())
