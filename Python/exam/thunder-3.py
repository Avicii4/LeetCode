class Solution:
    def __init__(self):
        self.res = 0
        self.profit = profit
        self.category = category
        self.n = n
        self.k = k

    def max_elegance(self):
        self.process(0, 0, 0, set())
        return self.res

    def process(self, cur_idx, cur_num, cur_profit, cur_cate):
        if cur_num == self.k:
            self.res = max(self.res, cur_profit + len(cur_cate) ** 2)
        if cur_idx == self.n:
            return

        # 做当前的项目
        newset = cur_cate.copy()
        newset.add(self.category[cur_idx])
        self.process(cur_idx + 1, cur_num + 1, cur_profit + self.profit[cur_idx], newset)

        # 不做当前的项目
        self.process(cur_idx + 1, cur_num, cur_profit, cur_cate)


n, k = map(int, input().split())
profit, category = [], []
for _ in range(n):
    a, b = map(int, input().split())
    profit.append(a)
    category.append(b)

print(Solution().max_elegance())
