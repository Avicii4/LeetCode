def all_odds(arr, n):
    """
    如果数组有奇数，直接返回偶数的个数
    如果数组全偶数，再看
    """
    odd_cnt = 0
    for num in arr:
        if num % 2 == 1:
            odd_cnt += 1
    if odd_cnt != 0:
        return n - odd_cnt
    else:
        # 最小是2 返回n  最小是4 返回n+1
        min_even = min(arr)
        op = 0
        while min_even % 2 == 0:
            min_even //= 2
            op += 1
        return op + n - 1


t = int(input())
for _ in range(t):
    n = int(input())
    lst = list(map(int, input().split()))
    print(all_odds(lst, n))