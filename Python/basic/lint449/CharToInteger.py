class Solution:
    """
    @param character: a character
    @return: An integer
    """

    def char_to_integer(self, character: str) -> int:
        # write your code here
        return ord(character)


if __name__ == '__main__':
    sol=Solution()
    print(sol.char_to_integer('%'))
