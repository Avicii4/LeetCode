def max_point(n, k):
    if n==1:
        return 1
    if n % 2 == 1:
        total = n // 2 + 1
    else:
        total = n // 2
    if k <= total:
        return k
    else:
        return n-k+1


t = int(input())
for _ in range(t):
    n, k = map(int, input().split())
    print(max_point(n, k))
