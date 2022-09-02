class Solution:
    """
    @param n: an integer
    @return: an integer f(n)
    """

    def fibonacci_1(self, n: int) -> int:
        a, b = 0, 1
        for _ in range(n - 1):
            a, b = b, a + b
        return a

    def fibonacci_2(self, n: int) -> int:
        arr = [0, 1, 1]
        for i in range(3, n + 1):
            arr.append(arr[i - 1] + arr[i - 2])
        return arr[n - 1]

    def fibonacci_3(self, n: int) -> int:
        arr = [0, 1]
        for i in range(2, n + 1):
            # 第一和第二个位置轮流存最新的一个数
            arr[i % 2] = arr[0] + arr[1]
        return arr[(n + 1) % 2]


if __name__ == '__main__':
    sol = Solution()
    for g in range(1, 10):
        print(sol.fibonacci_3(g))
