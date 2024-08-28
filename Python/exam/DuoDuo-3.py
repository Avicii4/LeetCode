def min_swap(n, x, lst):
    origin_lst = lst[:]
    lst.append(x)
    lst.sort()
    non_decrease_seq = set()
    non_decrease_seq.add(tuple(lst[1:]))
    non_decrease_seq.add(tuple(lst[:-1]))
    for i in range(n):
        if lst[i] == lst[i + 1]:
            non_decrease_seq.add(tuple(lst[:i] + lst[i + 1:]))

    res = float('inf')
    cur_op = 0
    for seq in non_decrease_seq:
        for idx in range(n):
            if seq[idx] != origin_lst[idx]:
                cur_op += 1
        res = min(res, cur_op)
    return res


n, x = map(int, input().split())
lst = list(map(int, input().split()))
print(min_swap(n, x, lst))
