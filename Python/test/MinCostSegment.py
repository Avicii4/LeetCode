from typing import List
import heapq


def violence(arr: List[int]) -> int:
    if not arr:
        return 0
    return process(arr, 0)


def process(arr, pre):
    if len(arr) == 1:
        return pre
    ans = 99999999
    # 穷举任意两个成员结合
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            # 数组去掉i和j位置的值，并将它们的和放到列表最后
            ans = min(ans, process(arr[:i] + arr[i + 1:j] + arr[j + 1:] + [arr[i] + arr[j]], pre + arr[i] + arr[j]))
    return ans


def copy_and_merge_two(arr, i, j):
    merged = []
    for k in range(len(arr)):
        if k != i and k != j:
            merged.append(arr[k])
            k += 1
    merged.append(arr[i] + arr[j])
    return merged


def greedy(arr):
    heap = []
    for elem in arr:
        heapq.heappush(heap, elem)
    sum, cur = 0, 0
    while len(heap) > 1:  # 弹出两个最小的，相加后放回堆中
        cur = heapq.heappop(heap) + heapq.heappop(heap)
        sum += cur
        heapq.heappush(heap, cur)
    return sum


if __name__ == '__main__':
    a = [10, 30, 20]
    print(greedy(a))
    print(violence(a))
