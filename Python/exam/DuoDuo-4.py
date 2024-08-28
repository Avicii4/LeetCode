def longest(string):
    return count(string)


def count(string):
    max_len = 1
    arr = []
    cur_len = 1
    for i in range(1, len(string)):
        if string[i] != string[i - 1]:
            cur_len += 1
        else:
            max_len = max(max_len, cur_len)
            arr.append(cur_len)
            cur_len = 1
    max_len = max(cur_len, max_len)
    arr.append(cur_len)
    return max_len,arr


n = int(input())
s = input().strip()
print(count())