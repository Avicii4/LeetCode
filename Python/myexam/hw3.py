from collections import deque


def func():
    number = int(input())
    volume = list(map(int, input().split()))  # 各盘的容量
    write_rate = list(map(int, input().split()))  # 写入比例
    rate_q = deque()
    for i in range(number):
        for _ in range(write_rate[i]):
            rate_q.append(i)
    x = int(input())  # 将要写入的内容量
    n = int(input())  # 每n次切换策略

    total_vol = sum(volume)
    target_rate = x / total_vol
    # 如果超出了容量，则直接返回0
    for v in volume:
        if target_rate * v > v:
            print(0)
            return
    rest = [v * target_rate for v in volume]

    def s1():
        i = 0
        for _ in range(n):
            rest[i] -= 4
            i += 1

    def s2():
        cur_q = rate_q.copy()
        for _ in range(n):
            cur_idx = cur_q.popleft()
            rest[cur_idx] -= 4
            if len(cur_q) == 0:
                cur_q = rate_q.copy()

    def s3():
        for _ in range(n):
            cur_max, cur_idx = rest[0], 0
            for i in range(1, number):
                if rest[i] > cur_max:
                    cur_max = rest[i]
                    cur_idx = i
            rest[cur_idx] -= 4

    res = 0

    change = (total_vol // 4) // n
    def dfs():

        for _ in range(change):
            for i in range(3):
                if i == 0:
                    s1()
                elif i == 1:
                    s2()
                else:
                    s3()
            if all([x >= 0 for x in rest]):
                continue

    while all([x >= 0 for x in rest]):
        for i in range(3):
            ...

    print(4)


if __name__ == "__main__":
    func()
