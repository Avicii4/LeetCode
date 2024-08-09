import sys

"""
https://www.bilibili.com/read/cv15996133/
https://juejin.cn/post/7129362778057343013
"""


def f1():
    """
    输入每行两个数，不定行数
    1 8
    4 10
    7 3
    """
    for line in sys.stdin:
        a, b = map(int, line.split())
        print('{} + {} = {}'.format(a, b, a + b))


def f2():
    """
    第一行输入行号n，接下来输入n行数字
    """
    n = int(input())
    for _ in range(n):
        a, b = map(int, input().split())
        print('{} + {} = {}'.format(a, b, a + b))


def f3():
    """
    不定行数，且如果一行是两个0，就停止
    """
    while True:
        a, b = map(int, input().split())
        if a == 0 and b == 0:
            break
        print('{} + {} = {}'.format(a, b, a + b))


def f4():
    """
    每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
    4 1 2 3 4
    5 1 2 3 4 5
    0
    """
    while True:
        lst = list(map(int, input().split()))
        if lst[0] == 0:
            break
        print(sum(lst[1:]))


def f5():
    for line in sys.stdin:
        lst = list(map(int, line.split()))
        print(sum(lst[1:]))


def f6():
    n = int(input())
    lst = input().split()
    lst.sort()
    for c in lst:
        print(c, end=" ")


def f7():
    """
    一行输入几个单词

    """
    for line in sys.stdin:
        list = line.split()
        list.sort()
        for c in list:
            print(c, end=" ")
        print()


if __name__ == '__main__':
    f7()
