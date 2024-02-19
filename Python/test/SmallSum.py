"""
在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和，求数组小和。
例如，`[1,3,4,2,5]`，其小和为：`1+1+3+1+1+3+4+2=16`
"""


def small_sum(arr):
    if arr is None or len(arr) < 2:
        return 0
    return process(arr, 0, len(arr) - 1)


def process(arr, left, right):
    if left == right:
        return 0
    mid = (left + right) >> 1
    return (process(arr, left, mid) +
            process(arr, mid + 1, right) +
            merge_both(arr, left, mid, right))


# def merge_both(arr, left, mid, right):
#     help = [0 for _ in range(right - left + 1)]
#     p, q = left, mid + 1  # 指向两部分数组各自的最左侧
#     cur = 0
#     res = 0
#     while p <= mid and q <= right:
#         if arr[p] < arr[q]:  # 仅在左侧元素<右侧元素的情况下：1.产生小和 2.拷贝左侧元素，否则全部拷贝右侧元素
#             res += (right - q + 1) * arr[p]  # 右半边数组中共有 right-q+1 个元素大于 arr[p]，则此时产生这么多的小和
#             help[cur] = arr[p]
#             cur += 1
#             p += 1
#         else:
#             help[cur] = arr[q]
#             cur += 1
#             q += 1
#     while p <= mid:
#         help[cur] = arr[p]
#         cur += 1
#         p += 1
#     while q <= right:
#         help[cur] = arr[q]
#         cur += 1
#         q += 1
#     for i in range(len(help)):
#         arr[left + i] = help[i]
#     return res


def merge_both(arr, left, mid, right):
    help = [0 for _ in range(right - left + 1)]
    p, q = left, mid + 1  # 指向两部分数组各自的最左侧
    cur = 0
    res = 0
    while p <= mid and q <= right:
        if arr[p] > arr[q]:  # 仅在左侧元素<右侧元素的情况下：1.产生小和 2.拷贝左侧元素，否则全部拷贝右侧元素
            res += right - q + 1  # 右半边数组中共有 right-q+1 个元素大于 arr[p]，则此时产生这么多的小和
            help[cur] = arr[p]
            cur += 1
            p += 1
        else:
            help[cur] = arr[q]
            cur += 1
            q += 1
    while p <= mid:
        help[cur] = arr[p]
        cur += 1
        p += 1
    while q <= right:
        help[cur] = arr[q]
        cur += 1
        q += 1
    for i in range(len(help)):
        arr[left + i] = help[i]
    return res


if __name__ == '__main__':
    # v = [1, 3, 4, 2, 5]
    v = [3, 1, 7, 0, 2]
    print(small_sum(v))
