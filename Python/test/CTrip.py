from itertools import permutations
from collections import defaultdict

"""
https://mp.weixin.qq.com/s/AE9kx4_c0-r83M1sFaEgpA
"""


def one():
    x = int(input())
    p = int(input())
    lst = list(str(x))
    num = [c for c in lst if int(c) % 2 == 1]
    num = int("".join(num))
    print(num % p)


def is_prime(num):
    if num == 2:
        return True
    if num <= 1:
        return False
    if num % 2 == 0:
        return False
    for i in range(3, int(num ** 0.5) + 1, 2):
        if num % i == 0:
            return False
    return True


def two():
    input_num = input().strip()
    n = len(input_num)
    lst = []
    visited = [False] * n

    def process(cur_seq):
        if len(cur_seq) == n:
            lst.append(cur_seq)
        for i in range(n):
            # 开头为0的数字不要
            if len(cur_seq) == 0 and input_num[i] == '0':
                continue
            if not visited[i]:
                visited[i] = True
                process(cur_seq + input_num[i])
                visited[i] = False

    process('')
    for num in lst:
        if is_prime(int(num)):
            print(num)
            break
    else:
        print(-1)


def three():
    n = int(input().strip())
    magic = defaultdict(int)
    for _ in range(n):
        a, b = map(int, input().split())
        magic[a] = b
    while True:
        val_lst = magic.values()
        if all([x <= 1 for x in val_lst]):
            break
        k = -1
        for k in magic:
            if magic[k] > 1:
                break
        val = magic[k]
        if val % 2 == 0:
            del magic[k]
            magic[k + 2] += val // 2
        else:
            magic[k] = 1
            magic[k + 2] += val // 2
    res = list(magic.keys())
    print(len(res))
    res.sort()
    for l in res:
        print(l, end=' ')


if __name__ == '__main__':
    three()
