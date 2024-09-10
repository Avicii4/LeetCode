def most_ones(num):
    res = -1
    for i in range(2, 37):
        s = convert(num, i)
        k = str(s).count('1')
        res = max(res, k)
    return res


def convert(num, base):
    if base < 2 or base > 36:
        return -1
    if num == 0:
        return 0
    digits = '0123456789abcdefghijklmnopqrstuvwxyz'
    res = ''
    while num > 0:
        remainder = num % base
        res = digits[remainder] + res
        num //= base
    return res


a = int(input())
print(most_ones(a))
