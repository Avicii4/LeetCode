def query(q, l, r, arr):
    res = arr[l]
    if q == 1:
        is_and = True
    elif q == 2:
        is_and = False

    for i in range(l + 1, r + 1):
        if is_and:
            res = res & arr[i]
            is_and = False
        else:
            res = res | arr[i]
            is_and = True
    return res


n, q = map(int, input().split())
a = list(map(int, input().split()))
queries = []
for _ in range(q):
    q, l, r = list(map(int, input().split()))
    print(query(q, l-1, r-1, a))
