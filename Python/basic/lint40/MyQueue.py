class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    """
    @param: element: An integer
    @return: nothing
    """

    def push(self, element):
        while self.s2:
            self.s1.append(self.s2.pop())
        self.s1.append(element)

    """
    @return: An integer
    """

    def pop(self):
        while self.s1:
            self.s2.append(self.s1.pop())
        return self.s2.pop()

    """
    @return: An integer
    """

    def top(self):
        while self.s1:
            self.s2.append(self.s1.pop())
        return self.s2[-1]

    def is_empty(self):
        return self.s1 or self.s2


if __name__ == '__main__':
    my_queue = MyQueue()
    my_queue.push(1)
    print(my_queue.pop())
    my_queue.push(2)
    my_queue.push(3)
    print(my_queue.top())
    print(my_queue.pop())
