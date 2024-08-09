"""
https://mp.weixin.qq.com/s?__biz=MzkyNTQ3NDAzNw==&mid=2247488045&idx=2&sn=19fdb288dc2420c872c4e3f401220594&chksm=c1c75fb7f6b0d6a13db0aabe0779158a74e905e6fb1ecfe99bf164645535368a6f70e0d5626d&scene=178&cur_album_id=2887532096360136706#rd
"""


def one():
    r, d, x = map(int, input().split())
    for _ in range(10):
        x = r * x - d
        print(x, end=' ')


def two():
    n = int(input().strip())
    s = input().strip()
    target, idx = 'pacman', 0
    print(s.count(target))


def three():
    string = input().strip()
    # 该map中，key是出现过的各种balance值，value是首次出现这个balance值时的下标
    balance_map = {0: -1}
    balance = 0
    res = 0
    """
    假设我现在在string上搜索，目前搜到的位置前面的内容是 ABA，那么balance就为1；
    之后我又搜到了后面的位置，当前内容是 ABAXXXX,发现balance也是1，
    那么就相当于XXXX这一块内容的和是0，也就是A和B数量相等，那么我得到了一个长度为4的AB平衡子串
    如此不断搜索，找到最大的平衡子串长度
    """
    for i, char in enumerate(string):
        if char == 'A':
            balance += 1
        else:
            balance -= 1
        if balance in balance_map:
            res = max(res, i - balance_map[balance])
        else:
            balance_map[balance] = i
    print(res)


if __name__ == '__main__':
    three()
