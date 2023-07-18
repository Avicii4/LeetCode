from typing import List
from random import randint


def exisit(nums: List[int], target: int) -> bool:
    """
    搜索是否存在一个数
    """
    nums.sort()
    left, right = 0, len(nums) - 1
    while left < right:
        mid = (left + right) >> 1
        if nums[mid] == target:
            return True
        elif nums[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    return nums[left] == target


def leftest_index(nums: List[int], target: int) -> int:
    """
    找到大等于target的最小下标位置
    小等于target的最大下标也是同理的
    """
    nums.sort()
    left, right = 0, len(nums) - 1
    res = -1
    while left <= right:  # 注意这里有等号！！
        mid = (left + right) >> 1
        if nums[mid] >= target:
            res = mid
            right = mid - 1
        else:
            left = mid + 1
    return res


def partial_min(nums: List[int]) -> int:
    """
    求数组中任意的一个局部最小值下标
    """
    n = len(nums)
    left, right = 0, n - 1
    while left < right:
        mid = (left + right) >> 1
        if nums[left] < nums[left + 1]:
            return left
        elif nums[right] < nums[right - 1]:
            return right
        elif nums[mid] > nums[mid - 1]:
            right = mid - 1
        elif nums[mid] > nums[mid + 1]:
            left = mid + 1
        else:
            return mid  # 此时 nums[mid-1] > nums[mid] < nums[mid+1]
    return left


if __name__ == '__main__':
    for _ in range(100):
        n, a = randint(1, 100), []
        for _ in range(n):
            t = randint(0, 1000)
            a.append(t)
        for i in range(n - 1):
            if a[i] == a[i + 1]:
                break
        res = partial_min(a)
        if (res == 0 and a[res] < a[res + 1]) or (res == n - 1 and a[res] < a[res - 1]) or (
                a[res - 1] > a[res] < a[res + 1]):
            pass
        else:
            print(a)
            print(res)
            exit('测试失败！')
    else:
        print('测试通过！')
