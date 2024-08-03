from Tree import TreeNode


class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        return self.process(root, p, q)[0]

    def process(self, cur, p, q):
        # 返回三个信息：
        # 1.目前p和q的公共祖先
        # 2.p是不是cur的孩子
        # 3.q是不是cur的孩子
        if cur is None:
            return None, False, False

        left_info = self.process(cur.left, p, q)
        right_info = self.process(cur.right, p, q)

        is_p_child = cur == p or left_info[1] or right_info[1]
        is_q_child = cur == q or left_info[2] or right_info[2]

        res = None
        if left_info[0] is not None:
            res = left_info[0]
        if right_info[0] is not None:
            res = right_info[0]
        if res is None:  # 上面两个if都没有命中
            if is_p_child and is_q_child:
                res = cur

        return res, is_p_child, is_q_child
