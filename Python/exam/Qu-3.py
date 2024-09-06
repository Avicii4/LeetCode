from collections import Counter


def max_k(n, string):
    cur_k = 0
    res = process(string, 0, 1, cur_k)
    return res


def process(string, cur_start_idx, cur_idx, cur_k):
    if cur_idx >= len(string):
        return -1
    if cur_idx == len(string) - 1:
        if isValid(Counter(string[cur_start_idx:])):
            return cur_k + 1
        else:
            return -1
    if isValid(Counter(string[cur_start_idx:cur_idx + 1])):
        # 1. 算找到一个划分，开启下一个新的
        plana = process(string, cur_idx + 1, cur_idx + 2, cur_k + 1)
        # 2. 忽略，直接跳下一个
        planb = process(string, cur_start_idx, cur_idx + 1, cur_k)
        return max(plana, planb)
    else:
        return process(string, cur_start_idx, cur_idx + 1, cur_k)


def isValid(cnt):
    odd_count = sum(1 for count in cnt.values() if count % 2 != 0)
    if odd_count == 0 or odd_count == 1:
        return True
    else:
        return False


n = int(input())
string = input()
print(max_k(n, string))
