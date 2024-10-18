def process(s):
    n = len(s)
    lst = [s[i] for i in range(n) if i % 2 == 1]
    a = []
    b = []
    for i in range(0, n, 2):
        if i % 4 == 0:
            a.append(s[i])
        if (i + 2) % 4 == 0:
            b.append(s[i])
    if n % 2 == 1:
        lst += a
        lst += b[::-1]
    else:
        lst += b
        lst += a[::-1]
    return "".join(lst)


s = input().strip()
print(process(s))
