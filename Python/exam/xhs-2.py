def min_sum(n, arr):
    arr.sort(reverse=True)
    l, r = 0, n - 1
    new_arr = [0 for _ in range(n)]
    for i in range(n):
        if i % 2 == 0:
            new_arr[l] = arr[i]
            l += 1
        else:
            new_arr[r] = arr[i]
            r -= 1

    total_sum = 0
    for i in range(n):
        con = (i + 1) * (n - i) * new_arr[i]
        total_sum += con
    return total_sum



n = int(input())
arr = list(map(int, input().split()))
print(min_sum(n, arr))
