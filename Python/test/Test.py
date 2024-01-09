from time import time
from typing import List
import random


def bubble_sort(nums: List[int]):
    n = len(nums)
    for i in range(n - 1, 0, -1):
        flag = True  # 在一轮中是否产生交换，没交换则为False
        for j in range(i):
            if not flag:
                break
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
                flag = True


def bubble_sort_no(nums: List[int]):
    n = len(nums)
    for i in range(n - 1, 0, -1):
        for j in range(i):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]


def insertion_sort(nums: List[int]):
    n = len(nums)
    for i in range(1, n):
        tmp = nums[i]
        j = i - 1
        while j >= 0 and tmp < nums[j]:  # 注意这里用while
            nums[j + 1] = nums[j]
            j -= 1
        nums[j + 1] = tmp


def selection_sort(nums: List[int]):
    n = len(nums)
    for i in range(n):
        cur = i
        for j in range(i + 1, n):  # 注意从i+1位置开始搜
            if nums[cur] > nums[j]:
                cur = j
        nums[i], nums[cur] = nums[cur], nums[i]


if __name__ == '__main__':
    # 排序正确性测试
    for _ in range(100):
        array_length = random.randint(1, 1000)
        random_array_1 = [random.randint(-1000, 1000) for _ in range(array_length)]
        random_array_2 = random_array_1.copy()
        selection_sort(random_array_1)
        random_array_2.sort()
        if not random_array_1 == random_array_2:
            print('Wrong!')
            break
    else:
        print('Success!')

    # bubble flag 测试： 至少对于Python来说，这种优化没有效果，if判断还平添时间成本
    # array = [random.randint(-100000, 100000) for _ in range(10000)]
    # array_copy = array.copy()
    # t1 = time()
    # bubble_sort(array)
    # print('With flag: ', time() - t1)
    # t2 = time()
    # bubble_sort_no(array_copy)
    # print('Without flag:', time() - t2)
