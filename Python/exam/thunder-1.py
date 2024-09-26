def max_len(arr):
    left = 0
    count = {}
    res = 0
    max_freq = 0
    for right in range(len(arr)):
        count[arr[right]] = count.get(arr[right], 0) + 1
        max_freq = max(max_freq, count[arr[right]])

        while (right - left + 1) - max_freq > 3:
            count[arr[left]] -= 1
            if count[arr[left]] == 0:
                del count[arr[left]]
            left += 1

        res = max(res, right - left + 1)
    return res


lst = list(map(int, input().split()))
print(max_len(lst))
