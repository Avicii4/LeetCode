from typing import List
from random import randint


class Solution:
    """
    @param a: an integer array
    @return: nothing
    """

    def selection_sort(self, a: List[int]):
        n = len(a)
        for i in range(n):
            tmp = i
            for j in range(i + 1, n):
                if a[j] < a[tmp]:
                    tmp = j
            a[tmp], a[i] = a[i], a[tmp]

    def bubble_sort(self, a: List[int]):
        n = len(a)
        for j in range(1, n):
            flag = 0
            for i in range(n - j):
                if a[i] > a[i + 1]:
                    flag = 1
                    a[i], a[i + 1] = a[i + 1], a[i]
            if not flag:
                # 若 flag=0，说明本轮数组已有序，无需继续
                return

    def insertion_sort(self, a: List[int]):
        for i in range(1, len(a)):
            elem = a[i]
            j = i - 1
            while j >= 0 and elem < a[j]:
                a[j + 1] = a[j]
                j -= 1
            a[j + 1] = elem


if __name__ == '__main__':
    sol = Solution()
    # a = [4, 7, 0, 2, 1, 6, 3]
    # sol.insertion_sort(a)
    # print(a)

    for i in range(100):
        n, a = randint(1, 100), []
        for _ in range(n):
            a.append(randint(0, 1000))
        a_sort = sorted(a)
        sol.insertion_sort(a)
        if not a == a_sort:
            print(a)
            print(a_sort)
            exit('排序失败！')
    else:
        print('测试通过！')
