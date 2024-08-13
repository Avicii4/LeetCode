def min_cost(n, k, x, arr):
    # 1.删除第一个元素 x
    # 2.删除全部元素 k*MEX(arr)
    dp = [float('inf')] * (n + 1)
    dp[0] = 0
    for i in range(n + 1):
        dp[i] = dp[i - 1] + x
        for j in range(i):
            m = mex(arr[j:i])
            dp[i] = min(dp[i], dp[j] + k * m)
    print(dp[n])


# def process(cur_arr, k, x):
#     if len(cur_arr) == 0:
#         return 0
#     if len(cur_arr)*x < k * mex(cur_arr):
#         m = process(cur_arr[1:], k, x) + x
#         n = m
#     else:
#         m = process(cur_arr[1:], k, x) + x
#         n = process([], k, x) + k * mex(cur_arr)
#     return min(m, n)


def mex(arr):
    n = len(arr)
    seen = [False] * (n + 1)
    for num in arr:
        if 0 <= num <= n:
            seen[num] = True
    for i in range(n + 1):
        if not seen[i]:
            return i
    return n+1


group_num = int(input().strip())
for _ in range(group_num):
    n, k, x = map(int, input().split())
    arr = list(map(int, input().split()))
    min_cost(n, k, x, arr)
