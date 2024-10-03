class Solution:
    def preprocess(self, S):
        n = len(S)
        starts = [0] * n
        cur_start = 0
        for i in range(n):
            starts[i] = cur_start
            cur_start += (n - i)
        return starts

    def find_seg(self, starts, index):
        l, r = 0, len(starts) - 1
        while l < r:
            mid = (l + r + 1) // 2
            if starts[mid] <= index:
                l = mid
            else:
                r = mid - 1
        return l

    def get_char(self, S, starts, index):
        seg = self.find_seg(starts, index)
        pos = index - starts[seg]
        return S[seg + pos]

    def repeatString(self, S, l, r):
        starts = self.preprocess(S)
        print(starts)
        res = []
        for i in range(l - 1, r):
            res.append(self.get_char(S, starts, i))
        return "".join(res)


if __name__ == '__main__':
    print(Solution().repeatString("abcd", 2, 5))
