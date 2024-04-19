class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def create(self, n: int) -> TreeNode:
        # 节点值都要正整数
        target_val = 1 << (n - 1)
        root = TreeNode(target_val)
        root.left = self.build_tree(target_val >> 1)
        root.right = self.build_tree(target_val >> 1)
        return root

    def build_tree(self, cur_val) -> TreeNode:
        if cur_val == 0:
            return None
        new_node = TreeNode(cur_val)
        new_node.left = self.build_tree(cur_val >> 1)
        new_node.right = self.build_tree(cur_val >> 1)
        return new_node
