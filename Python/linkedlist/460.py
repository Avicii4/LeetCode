from collections import defaultdict

"""
区别于146 LRU 的设计，本题为每一种频率数的节点维护一个双向链表
"""


class Node:
    def __init__(self, val, prev=None, next=None):
        self.val = val
        self.prev, self.next = prev, next


class LinkedList:
    def __init__(self):
        self.least = Node(0)
        self.most = Node(0)
        self.least.next = self.most
        self.most.prev = self.least
        self.map = dict()   # 用于存储频率-节点

    def push_most(self, val):  # 插入到最常用的节点
        node = Node(val, self.most.prev, self.most)
        self.map[val] = node
        self.most.prev = node
        node.prev.next = node

    def pop(self, val):
        if val in self.map:
            node = self.map[val]
            node.next.prev = node.prev
            node.prev.next = node.next
            self.map.pop(val, None)

    def pop_least(self):  # 删除最少用的节点
        res = self.least.next.val
        self.pop(self.least.next.val)
        return res

    def update(self, val):  # 如果链表中有节点被访问，则需要更新
        self.pop(val)
        self.push_most(val)


class LFUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.lfu_freq = 0  # 当前的最小频率数，这样当容量满时，才知道要删除哪个频率对应的链表
        self.value_map = dict()  # 存储k-v
        self.freq_map = defaultdict(int)  # 存储k-freq
        self.list_map = defaultdict(LinkedList)  # 存储k对应的频率数-节点链表

    def counter(self, key):
        cnt = self.freq_map[key]  # 因为freq_map是defaultdict，没找到key就返回0
        self.freq_map[key] += 1  # 没有的话就新建后加1，有的话就频率增加1
        self.list_map[cnt].pop(key)  # 从原有频率链表中弹出
        self.list_map[cnt + 1].push_most(key)  # 加入更高频率的链表中，且为最新的节点
        if cnt == self.lfu_freq and len(self.list_map[cnt].map) == 0:
            # 如果当前最小频率数对应的链表已空，则更新最小频率数
            self.lfu_freq += 1

    def get(self, key: int) -> int:
        if key not in self.value_map:
            return -1
        self.counter(key)
        return self.value_map[key]

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return
        if key not in self.value_map and len(self.value_map) == self.capacity:
            # 删除LFU节点
            res = self.list_map[self.lfu_freq].pop_least()
            self.value_map.pop(res)
            self.freq_map.pop(res)
        self.value_map[key] = value
        self.counter(key)
        self.lfu_freq = min(self.lfu_freq, self.freq_map[key])


if __name__ == '__main__':
    # ["LFUCache","put","put","get","get","get","put","put","get","get","get","get"]
    # [     [3],  [2,2],[1,1], [2],  [1],  [2],  [3,3],[4,4],[3],  [2],  [1],   [4]]
    # [null,null,null,2,1,2,null,null,3,2,-1,4]
    cache = LFUCache(3)
    cache.put(2, 2)
    cache.put(1, 1)
    print(cache.get(2))
    print(cache.get(1))
    print(cache.get(2))
    cache.put(3, 3)
    cache.put(4, 4)
    print(cache.get(3))
    print(cache.get(2))
    print(cache.get(1))
    print(cache.get(4))
    # cache = LFUCache(2)
    # cache.put(1,1)
    # cache.put(2,2)
    # print(cache.get(1))
    # cache.put(3,3)
    # print(cache.get(2))
    # print(cache.get(3))
    # cache.print_link()
    # cache.put(4,4)
    # cache.print_link()
    # print(cache.get(1))
    # print(cache.get(3))
    # print(cache.get(4))
