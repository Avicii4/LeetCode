from collections import defaultdict


def build_graph_weight():
    """
    n个点，m条边，每行输入三个整数a,b,c, 表示a->b连接一条边权为c的边
    例如：
    4 3
    1 2 3
    2 3 2
    3 4 2
    """
    n, m = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(m):
        weight, a_node, b_node = map(int, input().split())
        graph[a_node].append((b_node, weight))
    return graph


def build_graph_no_weight():
    n, m = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(1, m):
        a_node, b_node = input().split()
        graph[a_node].append(b_node)
        graph[b_node].append(a_node)
    return graph


def bfs(graph, node):
    """宽度优先遍历"""
    queue = []  # 队列，类似树的BFS
    visited_set = set()  # 存储已遍历过的节点
    queue.insert(0, node)
    visited_set.add(node)
    while len(queue) > 0:
        cur_node = queue.pop()
        print(cur_node)
        for next in graph[cur_node]:
            if next not in visited_set:
                visited_set.add(next)
                queue.insert(0, next)


def dfs(graph, node):
    """深度优先遍历，非递归"""
    stack = []
    visited_set = set()  # 存储已遍历过的节点
    stack.append(node)
    visited_set.add(node)
    print(node)
    while len(stack) > 0:
        cur_node = stack.pop()
        for next in graph[cur_node]:
            if next not in visited_set:
                stack.append(cur_node)  # 先压父节点入栈
                stack.append(next)  # 再压子节点入栈
                visited_set.add(next)  # 本次记录的节点
                print(next)
                break


def dijkstra_1(graph, source):
    dist_map = dict()
    dist_map[source] = 0  # 源点到自己的距离是0
    selected_nodes = set()  # 已求过最短距离的节点

    min_node = get_min_dist_and_unselected_node(dist_map, selected_nodes)
    while min_node is not None:
        distance = dist_map[min_node]
        for item in graph[min_node]:
            to_node, weight = item
            if to_node not in dist_map:  # 新节点加入
                dist_map[to_node] = distance + weight
            else:  # 更新距离
                dist_map[to_node] = min(dist_map[to_node], distance + weight)

        selected_nodes.add(min_node)
        min_node = get_min_dist_and_unselected_node(dist_map, selected_nodes)
    return dist_map


def get_min_dist_and_unselected_node(dist_map, selected_nodes):
    """未被选择的节点中距离最小的节点"""
    min_node = None
    min_dist = float('inf')
    for key in dist_map:
        distance = dist_map[key]
        if key not in selected_nodes and distance < min_dist:
            min_node = key
            min_dist = distance
    return min_node


if __name__ == '__main__':
    """
    无权图
    5 11
    a b
    a c
    a d
    b c
    b e
    c a
    c b
    c d
    c e
    d a
    e d
    
    有权图
    5 8
    1 1 2
    7 1 3
    6 1 4
    2 2 3
    2 3 4
    170 2 5
    23 3 5
    4 4 5
    """
    graph = build_graph_weight()
    print()
    print(dijkstra_1(graph, 1))
