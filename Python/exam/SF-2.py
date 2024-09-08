def max_distance(x, y, k, day, n):
    total_d = 0
    idx = 0
    while day > 0:
        day -= 1
        cover_d = total_d + k
        cur_max_k, max_k_id = -1, -1
        while idx < n and x[idx] <= cover_d:
            # 在走的这一步内，可以获得的最大的增强
            if y[idx] > cur_max_k:
                cur_max_k = y[idx]
                max_k_id = idx
            idx += 1
        if cur_max_k == -1:
            total_d += k  # 没有任何增强可选，直接走k长度
        else:  # 有增强
            k += cur_max_k
            total_d = x[max_k_id]
    return total_d


def dfs(start, x, y, k, day, visited, n):
    idx = 0
    tmp_max = 0
    while day > 0:
        day -= 1
        cover_d = start + k
        while idx < n and x[idx] <= cover_d:
            # 在走的这一步内，可以获得哪些增强
            if not visited[idx]:
                visited[idx] = True
                tmp_max = max(tmp_max, dfs(start + x[idx], x, y, k + y[idx], day - 1, visited, n))
                visited[idx] = False
            idx += 1
    return tmp_max


t = int(input())
for _ in range(t):
    # k是初始每天步长
    # day是总天数
    # n是获得增强的位置数量，也就是xy数组长度
    k, day, n = map(int, input().split())
    x = list(map(int, input().split()))  # 可获得增强的位置
    y = list(map(int, input().split()))  # 对应可得增强步长
    visited = [False for _ in range(n)]
    print(dfs(0, x, y, k, day, visited, n))
