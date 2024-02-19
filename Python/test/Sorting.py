from typing import List
from random import randint


def bubble_sort(nums: List[int]):
    n = len(nums)
    flag = True
    for i in range(n - 1, 0, -1):
        if not flag:
            return nums
        for j in range(i):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
                flag = True


def insertion_sort(nums: List[int]):
    for i in range(1, len(nums)):
        tmp = nums[i]  # 要插进前面的数
        j = i - 1
        while j >= 0 and nums[j] >= tmp:  # 注意这里用while; 若前面的数更大，则挪后面去
            nums[j + 1] = nums[j]
            j -= 1
        nums[j + 1] = tmp  # 此时位置合适，插入 tmp


def insertion_sort_2(nums: List[int]):
    for i in range(1, len(nums)):
        for j in range(i - 1, -1, -1):
            if nums[j + 1] < nums[j]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]


def selection_sort(nums: List[int]):
    n = len(nums)
    for i in range(n - 1):
        tmp = i
        for j in range(i + 1, n):
            if nums[tmp] > nums[j]:
                tmp = j
        nums[i], nums[tmp] = nums[tmp], nums[i]


def merge_sort(nums: List[int]):
    if nums is None or len(nums) < 2:
        return
    process(nums, 0, len(nums) - 1)


def process(nums, left, right):
    if left == right:
        return
    mid = (left + right) >> 1
    process(nums, left, mid)
    process(nums, mid + 1, right)
    merge_both(nums, left, mid, right)


def merge_both(nums, left, mid, right):
    help = [0 for _ in range(right - left + 1)]
    p, q = left, mid + 1  # 指向两部分数组各自的最左侧
    cur = 0
    while p <= mid and q <= right:
        if nums[p] <= nums[q]:
            help[cur] = nums[p]
            p += 1
        else:
            help[cur] = nums[q]
            q += 1
        cur += 1
    while p <= mid:
        help[cur] = nums[p]
        cur += 1
        p += 1
    while q <= right:
        help[cur] = nums[q]
        cur += 1
        q += 1
    for i in range(len(help)):
        nums[left + i] = help[i]


def merge_sort_iter(nums: List[int]):
    if nums is None or len(nums) < 2:
        return
    merge_size = 1  # 要merge的左组长度，左组右组的组内是有序的
    n = len(nums)
    while merge_size < n:
        left = 0
        while left < n:
            mid = left + merge_size - 1  # 左组的最右位置
            if mid >= n:  # 剩下的数不够再分出左右两组了，它们肯定是有序的
                break
            # left...mid  /  mid+1...right
            right = min(mid + merge_size, n - 1)  # 右组的最右位置
            merge_both(nums, left, mid, right)
            left = right + 1  # 进行本轮的下一次左右组merge
        merge_size <<= 1


if __name__ == '__main__':
    # 用户对数生成器测试
    for _ in range(1000):
        n, a = randint(1, 100), []
        for _ in range(n):
            a.append(randint(0, 1000))
        a_sort = sorted(a)
        merge_sort_iter(a)
        if not a == a_sort:
            print(a)
            print(a_sort)
            exit('排序失败！')
    else:
        print('测试通过！')

