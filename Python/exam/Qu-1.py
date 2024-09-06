from functools import cmp_to_key


def cmp(a, b):
    # 都是正的
    if int(a) > 0 and int(b) > 0:
        if a + b > b + a:
            return 1
        elif a + b < b + a:
            return -1
        else:
            return 0
    elif int(a) < 0 and int(b) < 0:
        a, b = a[1:], b[1:]
        if a + b > b + a:
            return 1
        elif a + b < b + a:
            return -1
        else:
            return 0
    elif int(a) == 0 and int(b) == 0:
        return 0
    elif int(a) == 0 and int(b) > 0:
        return -1
    elif int(a) == 0 and int(b) < 0:
        return 1
    elif int(b) == 0 and int(a) > 0:
        return 1
    elif int(b) == 0 and int(a) < 0:
        return -1
    else:  # 一正一负
        if a > b:
            return 1
        else:
            return -1


def compare(a, b):
    if int(a) < 0 and int(b) < 0:
        a, b = a[1:], b[1:]
    if a + b > b + a:
        return 1
    elif a + b < b + a:
        return -1
    else:
        return 0


n = int(input().strip())
arr = input().split()
neg_arr = [x for x in arr if int(x) < 0]
zero_arr = [x for x in arr if int(x) == 0]
pos_arr = [x for x in arr if int(x) > 0]

neg_arr.sort(key=cmp_to_key(cmp))
pos_arr.sort(key=cmp_to_key(cmp))
lst = neg_arr + zero_arr + pos_arr
print(" ".join(lst))
