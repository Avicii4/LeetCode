def days(n):
    res = 0
    while n > 0:
        if is_prime(n):
            n -= (n // 3) + 1
        else:
            n -= (n // 2) + 1
        res += 1
    return res


def is_prime(n):
    # if n <= 1:
    #     return False
    if n == 2 or n == 3:
        return True
    if n % 6 != 1 and n % 6 != 5:
        return False
    for i in range(5, int(n ** 0.5) + 1, 6):
        if n % i == 0 or n % (i + 2) == 0:
            return False
    return True


n = int(input())
print(days(n))
