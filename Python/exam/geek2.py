def step(n, m):
    res = 0
    while str(m) != str(m)[::-1]:
        res += 1
        if res > 30:
            break
        reverse_m = int(str(m)[::-1])
        m = add(m, reverse_m, n)

    return "STEP={}".format(res) if res <= 30 else "Impossible!"


def add(a, b, base):
    res = 0
    carry = 0
    for i in range(len(str(a))):
        x = a % 10
        y = b % 10
        x //= 10
        y //= 10
        cur = x + y + carry
        carry = cur // base
        cur = cur % base
        res = res * base + cur
    if carry != 0:
        res = res * base + carry
    return res


print(add(10, 10, 2))

n = int(input().strip())  # 进制
m = int(input().strip())  # 数字
print(step(n, m))
