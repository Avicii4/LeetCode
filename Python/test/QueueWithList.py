class Queue:
    def __init__(self, max_len):
        self.size = 0
        self.put_index = 0
        self.poll_index = 0
        self.max_len = max_len
        self.queue = [None] * self.max_len

    def add_elem(self, element):
        if self.size < self.max_len:
            self.queue[self.put_index] = element
            self.size += 1
            self.put_index = (self.put_index + 1) % self.max_len
        else:
            print("Queue is full. Cannot add more elements.")

    def remove_elem(self):
        if self.size == 0:
            print("Queue is empty")
            return None
        removed_element = self.queue[self.poll_index]
        self.poll_index = (self.poll_index + 1) % self.max_len
        self.size -= 1
        return removed_element


if __name__ == '__main__':
    # Example usage:
    queue = Queue(5)
    queue.add_elem(54)
    queue.add_elem(22)
    queue.add_elem(22)
    queue.add_elem(301)
    queue.add_elem(301)
    queue.add_elem(301)
    print("Size:", queue.size)
    # removed_element = queue.remove_elem()
    # print("Removed Element:", removed_element)
    # print("Size after Remove:", queue.size)
