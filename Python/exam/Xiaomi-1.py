"""
小A每天都要吃a,b两种面包各一个。而他有n个不同的面包机，不同面包机制作面包的时间各不相同。
第i台面包机制作a面包需要花费ai的时间，制作b面包则需要花费bi的时间。为能尽快吃到这两种面包，
小A可以选择两个不同的面包机x,y同时工作，并分别制作a,b两种面包，花费的时间将是max{ax,by}。
当然，小A也可以选择其中一个面包机x制作a,b两种面包，花费的时间将是ax+bx。
为能尽快吃到面包，请你帮小A计算一下，至少需要花费多少时间才能完成这两种面包的制作。
"""


def min_time(n, a, b):
    # 找到最小的制作A面包和B面包的时间以及对应的索引
    min_a, idx_a = a[0], -1
    min_b, idx_b = b[0], -1
    for i in range(n):
        if a[i] < min_a:
            min_a, idx_a = a[i], i
        if b[i] < min_b:
            min_b, idx_b = b[i], i

    res = 0
    if min_a == min_b:  # 时间最短的是同一台机器
        # 两种选择：1. 同一台机器制作，时间是a[i] + b[i]
        # 2. 找到第二小的时间组合
        min_same_machine = min_a + min_b
        second_min = float('inf')
        for i in range(n):
            if i != min_a:
                second_min = min(second_min, max(a[i], b[min_a]))
                second_min = min(second_min, max(a[min_a], b[i]))
        res = min(min_same_machine, second_min)
    else:  # 时间最短的不是同一台机器
        res = max(min_a, min_b)
    return res


n = int(input())
machine_a = list(map(int, input().split()))
machine_b = list(map(int, input().split()))
print(min_time(n, machine_a, machine_b))
