class MyQueue:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    """
    @param: element: An integer
    @return: nothing
    """

    def push(self, element):
        self.s1.append(element)

    """
    @return: An integer
    """

    def pop(self):
        while self.s1:
            p = self.s1.pop()
            self.s2.append(p)
        res = self.s2.pop()
        while self.s2:
            p = self.s2.pop()
            self.s1.append(p)
        return res

    """
    @return: An integer
    """

    def top(self):
        while self.s1:
            p = self.s1.pop()
            self.s2.append(p)
        res = self.s2[-1]
        while self.s2:
            p = self.s2.pop()
            self.s1.append(p)
        return res


if __name__ == '__main__':
    my_queue = MyQueue()
    my_queue.push(1)
    print(my_queue.pop())
    my_queue.push(2)
    my_queue.push(3)
    print(my_queue.top())
    print(my_queue.pop())


