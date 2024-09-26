from collections import Counter


def func(s):
    n = len(s)
    dp = [Counter("") for _ in range(n + 1)] * (n + 1)
    res = 0
    for i in range(0, n - 2):
        for j in range(i + 3, n + 1, 3):
            cnt = Counter(s[i:j-3]) + Counter(s[j-3:j])
            dp[i][j] = cnt
            if cnt['r'] == cnt['e'] == cnt['d']:
                res += 1
    return res


s = input()
print(func(s))
