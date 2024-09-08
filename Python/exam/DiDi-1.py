def beauty(n, m):
    if n == 1:
        return 0
    if n == 2:
        return m
    return 2 * m


t = int(input())
for _ in range(t):
    n, m = map(int, input().split())  # n个格子，m个藏品
    print(beauty(n, m), end=' ')
