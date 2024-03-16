class Heap:
    """
    自己实现的（大根）堆结构
    """

    def __init__(self):
        self.heap_size = 0
        self.heap = []

    def is_empty(self):
        return len(self.heap) == 0

    def get_size(self):
        return self.heap_size

    def output_heap(self):
        print(self.heap[:self.heap_size])

    def heap_push(self, value):
        """
        为堆添加新元素，且依然保证大根堆性质
        """
        self.heap.append(value)
        self.heap_insert()
        self.heap_size += 1

    def heap_insert(self):
        index = self.heap_size
        # 反复和自己的父节点比较
        while self.heap[index] > self.heap[(index - 1) // 2]:
            self.heap[index], self.heap[(index - 1) // 2] = self.heap[(index - 1) // 2], self.heap[index]
            index = (index - 1) // 2

    def heap_pop(self):
        res = self.heap[0]
        self.heap_size -= 1
        self.heap[0], self.heap[self.heap_size] = self.heap[self.heap_size], self.heap[0]
        self.heapify(0)
        return res

    def heapify(self, index):
        lchild_idx = 2 * index + 1
        while lchild_idx < self.heap_size:
            if lchild_idx + 1 < self.heap_size and self.heap[lchild_idx] < self.heap[lchild_idx + 1]:
                larger_idx = lchild_idx + 1
            else:
                larger_idx = lchild_idx
            larger_idx = larger_idx if self.heap[larger_idx] > self.heap[index] else index
            if larger_idx == index:
                break
            self.heap[larger_idx], self.heap[index] = self.heap[index], self.heap[larger_idx]
            index = larger_idx
            lchild_idx = 2 * lchild_idx + 1


if __name__ == '__main__':
    h = Heap()
    h.heap_push(9)
    h.heap_push(3)
    h.heap_push(6)
    h.heap_push(5)
    h.heap_push(7)
    h.output_heap()
