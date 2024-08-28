from collections import defaultdict


def build_tree(edges):
    adj = defaultdict(list)
    for u, v, weight in edges:
        adj[u].append((v, weight))
        adj[v].append((u, weight))
    return adj


def max_score(tree, v_list, n):
    adj = build_tree(tree)
    tree.sort(key=lambda x: x[2])
    K = 1
    del_edges = set()
    for i in range(K):
        del_edges.add((tree[i][0], tree[i][1]))
    visited = set()
    residual = 0

    def dfs(node):
        nonlocal residual
        queue = [node]
        visited.add(node)
        while len(queue) > 0:
            cur = queue.pop()
            for neighbor, weight in adj[cur]:
                if (cur, neighbor) not in del_edges and (neighbor, cur) not in del_edges:
                    residual += weight
                    if neighbor not in visited:
                        visited.add(neighbor)
                        queue.insert(0, neighbor)

    components = 0

    for node in adj:
        if node not in visited:
            components += 1
            dfs(node)

    return residual // 2 + v_list[components - K]


t = int(input())
for _ in range(t):
    n = int(input())
    v_list = list(map(int, input().split()))
    tree = []
    for _ in range(n - 1):
        a, b, w = map(int, input().split())
        tree.append((a, b, w))

    print(max_score(tree, v_list, n))
