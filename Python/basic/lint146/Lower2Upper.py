class Solution:
    """
    @param letters: A string
    @return: A string
    """

    def lowercase_to_uppercase2(self, letters: str) -> str:
        letters = list(letters)
        length = len(letters)
        for i in range(length):
            if 97 <= ord(letters[i]) <= 122:
                letters[i] = letters[i].upper()
        return ''.join(letters)


if __name__ == '__main__':
    sol = Solution()
    print(sol.lowercase_to_uppercase2('aBcdft67'))
