"""
并查集的定义与常用操作
"""

class UnionFindSet(object):

    def __init__(self, data_list):
        # 存储节点-->代表点的映射关系
        self.parent_dict = {}
        # 只有一个节点是某个集合的代表点时，才存到字典中
        self.size_dict = {}

        for node in data_list:
            self.parent_dict[node] = node  # 初始时，每个节点指向自己
            self.size_dict[node] = 1  # 每个集合一开始就1个节点

    def find_parent(self, node):
        """
        给定节点node，查找节点的代表点并返回
        优化：顺便把沿途所有节点的代表点直接改成最高的代表点
        """
        path = []  # 用于记录沿途的结点
        while node != self.parent_dict[node]:
            path.append(node)
            node = self.parent_dict[node]

        # 此时node来到了代表点
        while len(path) > 0:
            self.parent_dict[path.pop()] = node
        return node

    def is_same_set(self, node_a, node_b):
        """
        查询node_a和node_b是否在同一个集合里
        """
        return self.find_parent(node_a) == self.find_parent(node_b)

    def union(self, node_a, node_b):
        """
        将两个集合合并在一起
        """
        if node_a is None or node_b is None:
            return
        a_head = self.find_parent(node_a)
        b_head = self.find_parent(node_b)

        if a_head != b_head:  # 只在两者不在一个集合时进行下述操作
            a_set_size = self.size_dict[a_head]
            b_set_size = self.size_dict[b_head]
            # 优化：求集合大小，把小的挂在大的集合之下，减小遍历链条的长度
            if a_set_size >= b_set_size:
                self.parent_dict[b_head] = a_head
                self.size_dict[a_head] = a_set_size + b_set_size
                self.size_dict.pop(b_head, 0)  # 删除设定一个默认值，防止删掉不存在的key而报错
            else:
                self.parent_dict[a_head] = b_head
                self.size_dict[b_head] = a_set_size + b_set_size
                self.size_dict.pop(a_head, 0)
