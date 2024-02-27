import random
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


"""
归并排序
"""
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


"""
快速排序
"""
def quick_sort(nums: List[int]):
    if nums is None or len(nums) < 2:
        return
    quick_process(nums, 0, len(nums) - 1)


def quick_process(nums, left, right):
    if left >= right:
        return
    rand_loc = random.randint(left, right)
    # 随机换一个数到 [right] 位置上，后续pivot值就选择nums[right]
    nums[rand_loc], nums[right] = nums[right], nums[rand_loc]
    equal_area = partition(nums, left, right)
    quick_process(nums, left, equal_area[0] - 1)
    quick_process(nums, equal_area[1] + 1, right)


def partition(nums, left, right):
    """
    随机选nums中一个数为pivot值，将数组nums划分为三个部分：
    小于pivot值的区域，等于pivot值的区域，大于pivot值的区域
    :return: 等于pivot值的区域的左、右边界
    """
    if left > right:  # 这种情况无意义
        return [-1, -1]
    if left == right:
        return [left, right]

    pivot = nums[right]
    less = left - 1  # 小于pivot区域的右边界
    more = right  # 大于pivot区域的左边界
    i = left
    while i < more:
        if nums[i] == pivot:
            i += 1
        elif nums[i] < pivot:
            less += 1
            nums[i], nums[less] = nums[less], nums[i]
            i += 1
        else:
            more -= 1
            nums[i], nums[more] = nums[more], nums[i]

    nums[right], nums[more] = nums[more], nums[right]
    return [less + 1, more]


"""
堆排序
"""
def heap_sort(nums: List[int]):
    """
    1. 先将整个数组调整为大根堆
    2. 将全局最大值放到最后面，然后调整堆(heapify)，再heap_size--
    3. 重复第2步
    """
    if nums is None or len(nums) < 2:
        return

    # 把原数组整理成大根堆，这里复杂度是 O(N)
    for i in range(len(nums) - 1, -1, -1):
        heapify(nums, i, len(nums))

    heap_size = len(nums) - 1
    nums[heap_size], nums[0] = nums[0], nums[heap_size]  # 最大值到最后去
    while heap_size > 0:
        heapify(nums, 0, heap_size)  # 新换上来的根节点往下沉
        heap_size -= 1
        nums[heap_size], nums[0] = nums[0], nums[heap_size]  # 最大值到最后去


def heapify(nums, index, heap_size):
    """
    从index位置不断往下比较，维护大根堆的性质
    """
    lchild_idx = 2 * index + 1
    while lchild_idx < heap_size:
        if lchild_idx + 1 < heap_size and nums[lchild_idx + 1] > nums[lchild_idx]:
            # 有右孩子且右孩子更大，则记录右孩子下标
            larger_idx = lchild_idx + 1
        else:
            # 否则记录左孩子下标
            larger_idx = lchild_idx
        # 看一看较大的孩子和父节点的大小关系
        larger_idx = larger_idx if nums[larger_idx] > nums[index] else index
        if larger_idx == index:  # 父节点就是较大节点，不需要往下比较了
            break
        nums[larger_idx], nums[index] = nums[index], nums[larger_idx]
        index = larger_idx
        lchild_idx = 2 * index + 1  # 继续往下


if __name__ == '__main__':
    # 用户对数生成器测试
    for _ in range(10000):
        n, a = randint(1, 100), []
        for _ in range(n):
            a.append(randint(0, 1000))
        a_sort = sorted(a)
        # merge_sort_iter(a)
        # quick_sort(a)
        heap_sort(a)
        if not a == a_sort:
            print(a)
            print(a_sort)
            exit('排序失败！')
    else:
        print('测试通过！')
