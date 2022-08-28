from typing import (
    List,
)


class Solution:
    """
    @param a: An integer array
    @param index1: the first index
    @param index2: the second index
    @return: nothing
    """

    def swap_integers(self, a: List[int], index1: int, index2: int):
        a[index1], a[index2] = a[index2], a[index1]


if __name__ == '__main__':
    sol = Solution()
    a = [1, 2, 2, 2]
    m, n = 0, 3
    sol.swap_integers(a, m, n)
    print(a)
