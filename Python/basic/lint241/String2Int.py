class Solution:

    def stringToInteger(self, target: str) -> int:
        n = len(target)
        if target[0] == '-':
            flag, n = -1, n - 1
        else:
            flag = 1
        num = 0
        for i in range(len(target) - n, len(target)):
            num += ord(target[i]) - 48
            num *= 10
        return num // 10 * flag


if __name__ == '__main__':
    sol = Solution()
    print(sol.stringToInteger('710'))
    print(sol.stringToInteger('-710'))
    print(sol.stringToInteger('0'))
    print(sol.stringToInteger('6'))
    print(sol.stringToInteger('-1'))
    print(sol.stringToInteger('871021'))
    print(sol.stringToInteger('45'))
