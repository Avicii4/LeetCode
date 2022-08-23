class Solution:
    """
    @param num1: An integer
    @param num2: An integer
    @param num3: An integer
    @return: an interger
    """
    def max_of_three_numbers(self, num1: int, num2: int, num3: int) -> int:
        tmp = num1 if num1>num2 else num2
        return tmp if tmp>num3 else num3


if __name__ == '__main__':
    sol = Solution()
    print(sol.max_of_three_numbers(1,61,6))
