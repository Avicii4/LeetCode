def min_op(n, x, arr):
    total_sum=sum(arr)
    remainder = total_sum % x
    if remainder == 0:
        return 0
    if remainder in arr:
        return 1

    return process(remainder, arr, x)


def process(remainder, arr, x):
    if remainder == 0:
        return 0
    if remainder in arr:
        return 1
    r_list = [num % x for num in arr]
    cnt = 0
    while remainder >= 0:
        if remainder in r_list:
            return cnt
        else:
            cnt += 1
            remainder -= 1


n, x = map(int, input().split())
arr = list(map(int, input().split()))
print(min_op(n, x, arr))
