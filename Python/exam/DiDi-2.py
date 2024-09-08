def max_cost(n, k, grid, s):
    # dp[l][r]表示字符串下标l到r的最大删除代价
    dp = [[0] * n for _ in range(n)]

    for length in range(2, n + 1, 2):
        for l in range(0, n - length + 1):  # 左边界
            r = l + length - 1  # 右边界
            if length == 2:
                dp[l][r] = get_price(s[l], s[r], grid)
            if length == 4:
                dp[l][r] = max(dp[l][l + 1] + dp[l + 2][l + 3],
                               get_price(s[l], s[l + 2], grid) + get_price(s[l + 1], s[l + 3], grid),
                               get_price(s[l], s[l + 3], grid) + get_price(s[l + 1], s[l + 2], grid))
            if length==6:
                dp[l][r] = max(dp[l][l+3]+get_price(s[l+4],s[l+5],grid),
                               dp[l+1][l+4]+get_price(s[l],s[l+5],grid),
                               dp[l+2][l+5]+get_price(s[l],s[l+1],grid),
                               )
            else:
                for m in range(l + 2, r, 2):
                    dp[l][r] = max(dp[l][r], dp[l][m] + dp[m + 1][r] + get_price(s[m], s[r], grid))

    return dp[0][n - 1]


def get_price(a, b, grid):
    return grid[ord(a) - ord('a')][ord(b) - ord('a')]




n, k = map(int, input().split())
grid = []
for _ in range(k):
    a = list(map(int, input().split()))
    grid.append(a)
string = input()
print(max_cost(n, k, grid, string))
