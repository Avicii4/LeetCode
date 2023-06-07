class Solution:
    """
    @param number: A 3-digit number.
    @return: Reversed number.
    """

    def reverse_integer(self, number: int) -> int:
        a = number // 100
        b = (number % 100) // 10
        c = number % 10
        return 100 * c + 10 * b + a


if __name__ == '__main__':
    sol = Solution()
    print(sol.reverse_integer(786))
