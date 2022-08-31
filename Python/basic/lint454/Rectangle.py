class Rectangle:

    def __init__(self, a, b):
        self.width = a
        self.height = b

    def getArea(self):
        return self.width * self.height


if __name__ == '__main__':
    res = Rectangle(3, 4)
    print(res.getArea())
