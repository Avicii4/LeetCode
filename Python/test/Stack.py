class StackWithMin:
    def __init__(self):
        self.stack = []
        self.min = []

    def push(self, x):
        self.stack.append(x)
        if len(self.min) == 0:
            self.min.append(x)
        else:
            new_elem = self.min[-1] if self.min[-1] < x else x
            self.min.append(new_elem)

    def pop(self):
        elem = self.stack.pop()
        self.min.pop()
        return elem

    def get_min(self):
        if len(self.min) == 0:
            return None
        return self.min[-1]


if __name__ == '__main__':
    stack = StackWithMin()
    stack.push(1)
    stack.push(-80)
    stack.push(3)
    stack.push(-100)
    stack.pop()
    print(stack.get_min())
