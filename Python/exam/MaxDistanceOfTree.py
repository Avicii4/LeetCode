import heapq


# 5
# 1 2
# 2 3
# 3 4
# 2 5
# 4 3 3 4 4


class Node:
    def __init__(self, val):
        self.val = val
        self.kids = []


def get_max_distance(node):
    if len(node.kids) == 0:
        return 1, 0
    dist_list, depth_list = [], []
    for kid_node in node.kids:
        a, b = get_max_distance(kid_node)
        dist_list.append(a)
        depth_list.append(b)
    cur_depth = max(depth_list) + 1
    top2 = heapq.nlargest(2, depth_list)
    cur_dist = max(max(dist_list), sum(top2) + 1)
    return cur_dist, cur_depth


# n = int(input())
# nodes = [Node(0)]
# for i in range(1, n + 1):
#     nodes.append(Node(i))
#
# for _ in range(n - 1):
#     pair = tuple(map(int, input().split()))
#     nodes[pair[0]].kids.append(nodes[pair[1]])
#
# for i in range(1, n + 1):
#     new_node = Node(n + 1)
#     nodes[i].kids.append(new_node)
#     print(get_max_distance(nodes[1])[0])
#     nodes[i].kids.remove(new_node)


n = 5
nodes = [Node(0)]
for i in range(1, n + 1):
    nodes.append(Node(i))

pairs = [(1, 2), (2, 3), (3, 4), (2, 5)]
for pair in pairs:
    nodes[pair[0]].kids.append(nodes[pair[1]])

for i in range(1, n + 1):
    new_node = Node(n + 1)
    nodes[i].kids.append(new_node)
    print(get_max_distance(nodes[1])[0])
    nodes[i].kids.remove(new_node)
