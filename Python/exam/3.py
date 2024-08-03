n, m = list(map(int, input().split()))
s = input()

dp = [0 for _ in range(n + 1)] * (m + 1)

S = [0 for _ in range(n + 1)] * (m + 1)

