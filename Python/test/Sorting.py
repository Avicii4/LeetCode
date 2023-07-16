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
        while j >= 0 and nums[j] >= tmp:  # 若前面的数更大，则挪后面去
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


if __name__ == '__main__':
    for _ in range(100):
        n, a = randint(1, 100), []
        for _ in range(n):
            a.append(randint(0, 1000))
        a_sort = sorted(a)
        insertion_sort_2(a)
        if not a == a_sort:
            print(a)
            print(a_sort)
            exit('排序失败！')
    else:
        print('测试通过！')
