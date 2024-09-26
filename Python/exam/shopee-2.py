import math


class Solution:
    def SumOfGreatestOddDivisor(self, n):
        res = 0
        for i in range(1, n + 1):
            res += self.f(i)
        return res

    def f(self, num):
        rightOne = num & (-num)
        n = int(math.log2(rightOne))
        print(num,num>>n)
        return num >> n


if __name__ == '__main__':
    print(Solution().SumOfGreatestOddDivisor(20))
