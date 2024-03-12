"""
更加偏向系统设计问题
需要一个字典（哈希表）随时找到键值对，才能满足查询时间O(1)
需要一个双向链表保存缓存区域的内容，
需要两个辅助节点，一个指向最近使用，一个指向最久未使用，这样可以满足操作时间O(1)
"""


class Node:  # 双向链表
    def __init__(self, key, val):
        self.key, self.val = key, val
        self.prev, self.next = None, None


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = dict()  # <key, *Node(k,v)>
        # least.next指向LRU，most.prev指向MRU
        self.least, self.most = Node(0, 0), Node(0, 0)
        # 开始时仅两个节点构成双向链表
        self.least.next = self.most
        self.most.prev = self.least

    def print_link(self):
        p = self.least
        while p:
            print('[{},{}]'.format(p.key, p.val), end='⇄')
            p = p.next
        print('Null')

    def insert(self, node):
        pre = self.most.prev
        pre.next = node
        node.prev, node.next = pre, self.most
        self.most.prev = node

    def remove(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def get(self, key: int) -> int:
        if key in self.map:
            # 删除这个节点，然后插入most前面
            p = self.map[key]
            self.remove(p)
            self.insert(p)
            return p.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self.remove(self.map[key])
        new_node = Node(key, value)
        self.insert(new_node)
        self.map[key] = new_node
        if len(self.map) > self.capacity:
            # 淘汰LRU，一定注意先删map，再删节点
            del self.map[self.least.next.key]
            self.remove(self.least.next)


if __name__ == '__main__':
    cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    print(cache.get(1))

    cache.print_link()
    cache.put(3, 3)
    cache.print_link()
    print(cache.map)
    print(cache.get(2))
