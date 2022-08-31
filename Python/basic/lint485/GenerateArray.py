from typing import (
    List,
)


class Solution:
    """
    @param size: An integer
    @return: An integer list
    """

    def generate(self, size: int) -> List[int]:
        # write your code here
        return list(range(1, size + 1))


if __name__ == '__main__':
    sol = Solution()
    print(sol.generate(10))
