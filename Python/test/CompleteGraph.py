class Node:
    def __init__(self, val):
        self.val = val
        self.in_degree = 0  # 入度
        self.out_degree = 0  # 出度
        self.nexts = []  # 记录本节点指向的直接邻居
        self.edges = []


class Edge:
    def __init__(self, weight, from_node, to_node):
        self.weight = weight  # 权重
        self.from_node = from_node  # 头节点
        self.to_node = to_node  # 尾节点


class Graph:
    def __init__(self):
        self.nodes = dict()  # 从编号到点对象的映射
        self.edges = set()


def create_by_matrix(mat):
    """
    如果输入的是一个N行3列的矩阵，分别表示：
    （有向）边的权重、头节点的值、尾节点的值
    本函数就将这个矩阵表示法转成上面定义的Graph结构
    """
    graph = Graph()
    for i in range(len(mat)):
        weight, from_val, to_val = mat[i]
        if from_val not in graph.nodes:
            graph.nodes[from_val] = Node(from_val)
        if to_val not in graph.nodes:
            graph.nodes[to_val] = Node(to_val)
        from_node = graph.nodes[from_val]
        to_node = graph.nodes[to_val]
        from_node.nexts.append(to_node)
        from_node.out_degree += 1
        to_node.in_degree += 1
        new_edge = Edge(weight, from_node, to_node)
        from_node.edges.add(new_edge)
        graph.edges.add(new_edge)
    return graph

