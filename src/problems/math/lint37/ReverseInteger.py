class Solution:
    """
    @param number: A 3-digit number.
    @return: Reversed number.
    """

    def reverse_integer(self, number: int) -> int:
        a = number // 100
        b = (number - a * 100) // 10
        c = number % 10
        return c * 100 + b * 10 + a


if __name__ == '__main__':
    sol = Solution()
    print(sol.reverse_integer(150))
