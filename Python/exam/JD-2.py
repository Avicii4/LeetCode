from collections import defaultdict


def paris(n, target, arr):
    d = defaultdict(int)
    res = 0
    for num in arr:
        d[num] = d[num] + 1
    for num in d:
        if target - num in d:
            if target != 2 * num:
                res += d[target - num]
            else:
                res += d[target - num] * d[target - num]

    print(res)


n, x = map(int, input().strip().split())
arr = list(map(int, input().strip().split()))
paris(n, x, arr)
