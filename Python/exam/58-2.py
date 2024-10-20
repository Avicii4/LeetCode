class Solution:
    def bitwiseComplement(self , n: int) -> int:
        b = bin(n)[2:]
        reverse = ''.join('1' if c=='0' else '0' for c in b)
        return int(reverse,2)


if __name__ == '__main__':
    print(Solution().bitwiseComplement(5))