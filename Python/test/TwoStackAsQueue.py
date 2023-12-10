class TwoStackAsQueue:
    def __init__(self):
        self.push_stack = []
        self.pop_stack = []

    def __push_to_pop(self):
        # pop栈为空才能向其倒入数据
        if len(self.pop_stack) == 0:
            # 一旦push栈要倒，就要全部倒入pop栈
            while len(self.push_stack) > 0:
                self.pop_stack.append(self.push_stack.pop())

    def push(self, x):
        self.push_stack.append(x)
        self.__push_to_pop()

    def pop(self):
        if len(self.pop_stack) == 0 and len(self.push_stack) == 0:
            print('Queue is empty.')
            return None
        self.__push_to_pop()
        return self.pop_stack.pop()

    def peek(self):
        if len(self.pop_stack) == 0 and len(self.push_stack) == 0:
            print('Queue is empty.')
            return None
        self.__push_to_pop()
        return self.pop_stack[-1]

if __name__ == '__main__':
    queue = TwoStackAsQueue()
    queue.push(1)
    print(queue.push_stack,queue.pop_stack)
    queue.push(2)
    print(queue.push_stack, queue.pop_stack)
    queue.push(3)
    print(queue.push_stack, queue.pop_stack)
    print('>>>',queue.pop())
    print(queue.push_stack, queue.pop_stack)
    print('>>>',queue.pop())
    print(queue.push_stack, queue.pop_stack)
    queue.push(4)
    print(queue.push_stack, queue.pop_stack)
    print('>>>',queue.pop())
    print(queue.push_stack, queue.pop_stack)
    print('>>>',queue.peek())
    print(queue.push_stack, queue.pop_stack)
