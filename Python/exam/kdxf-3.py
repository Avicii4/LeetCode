class TreeNode:
    def __init__(self, val):
        self.val = val
        self.nexts = []


def longest_path(root):
    def dfs(node):
        if node is None:
            return 0, 0, 0
        inc_list, dec_list = [], []
        cur_max = 0
        for child in node.nexts:
            child_inc, child_dec, cur_max = dfs(child)
            if child.val >= node.val:
                inc_list.append(child_inc)
            if child.val <= node.val:
                dec_list.append(child_dec)
        cur_inc_path, cur_dec_path = 1, 1
        # 孩子中取最大的两个
        if len(inc_list) == 1:
            cur_inc_path = inc_list[0] + 1
        if len(inc_list) >= 2:
            inc_list.sort(reverse=True)
            cur_inc_path = inc_list[0] + inc_list[1] + 1
        # 孩子中取最大的两个
        if len(dec_list) == 1:
            cur_dec_path = dec_list[0] + 1
        if len(dec_list) >= 2:
            dec_list.sort(reverse=True)
            cur_dec_path = dec_list[0] + dec_list[1] + 1
        cur_max = max(cur_max, cur_inc_path, cur_dec_path)
        a = inc_list[0] if len(inc_list) > 0 else 0
        b = dec_list[0] if len(dec_list) > 0 else 0
        return a+1, b+1, cur_max

    _, _, res = dfs(root)
    return res


n = int(input())
weights = list(map(int, input().split()))
node_lst = [TreeNode(weights[i]) for i in range(n)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    node_lst[a - 1].nexts.append(node_lst[b - 1])

print(longest_path(node_lst[0]))
# 6
# 8 1 2 3 4 5
# 1 2
# 2 3
# 3 4
# 2 5
# 5 6