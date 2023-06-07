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
    return nums


def insertion_sort(nums: List[int]):
    for i in range(1, len(nums)):
        tmp = nums[i]
        j = i - 1
        while j >= 0 and nums[j] >= tmp:
            nums[j + 1] = nums[j]
            j -= 1
        nums[j + 1] = tmp
    return nums

def selection_sort(nums: List[int]):
    ...



if __name__ == '__main__':
    for _ in range(100):
        n, a = randint(1, 100), []
        for _ in range(n):
            a.append(randint(0, 1000))
        a_sort = sorted(a)
        insertion_sort(a)
        if not a == a_sort:
            print(a)
            print(a_sort)
            exit('排序失败！')
    else:
        print('测试通过！')
