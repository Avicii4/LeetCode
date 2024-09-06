import heapq


# def min_days(n, m, growth, multiple):
#     def get_sum(k):
#         if k == 0:
#             return 0
#         max_heap = []
#         for j in range(k):
#             heapq.heappush(max_heap, -growth[0] * multiple[j])
#         total_sum = 0
#         for i in range(k):
#             largest_product = -heapq.heappop(max_heap)
#             total_sum += largest_product
#             if i + 1 < k:
#                 for j in range(k):
#                     heapq.heappush(max_heap,-growth[i + 1] * multiple[j])
#         return total_sum
#
#     l, r = 0, n
#     while l <= r:
#         mid = (l + r) // 2
#         product_sum = get_sum(mid)
#         if product_sum >= m:
#             r = mid - 1
#         else:
#             l = mid + 1
#     return l if l < n else -1

def min_days(n, m, growth, multiple):
    for i in range(n):
        a = sorted(growth[:i + 1], reverse=True)
        b = sorted(multiple[:i + 1], reverse=True)
        s = sum([a[j] * b[j] for j in range(i)])
        if s >= m:
            return i
    return -1


n, m = map(int, input().split())  # 总任务数和目标的数值
growth = list(map(int, input().split()))
multiple = list(map(int, input().split()))
print(min_days(n, m, growth, multiple))
