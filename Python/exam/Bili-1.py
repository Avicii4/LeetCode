def min_op(string):
    res = 0
    mid = len(string) // 2
    front, rear = string[0:mid], string[mid:]
    for i in range(len(front)):
        if front[i] != rear[i]:
            res += 1
    return res


s = input().strip()
print(min_op(s))
