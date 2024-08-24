from itertools import permutations


def f(n, m):
    all = permutations(str(n))
    all = [x for x in all if x[0] != '0']
    res = 0
    for elem in all:
        num = int("".join(elem))
        print(num)
        if num % m == 0:
            res += 1
    return res


n, m = map(int, input().split())
print(f(n, m))
