from lintcode import (
    TreeNode,
)

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""


class Solution:
    """
    @param root: the root of tree
    @return: the max node
    """

    def max_node_1(self, root: TreeNode) -> TreeNode:
        if root is None:
            return root
        left = self.max_node(root.left)
        right = self.max_node(root.right)
        return self.find_max(root, self.find_max(left, right))

    def find_max(self, p: TreeNode, q: TreeNode) -> TreeNode:
        if p is None:
            return q
        if q is None:
            return p
        if p is not None and q is not None:
            if p.val > q.val:
                return p
            else:
                return q

    def max_node_2(self, root: TreeNode) -> TreeNode:
        if not root:
            return root
        lst = [root]
        cur_max = root
        while lst:
            p = lst.pop(0)
            if p.val > cur_max.val:
                cur_max = p
            if p.left:
                lst.append(p.left)
            if p.right:
                lst.append(p.right)
        return cur_max


if __name__ == '__main__':
    sol = Solution()
    head = TreeNode(1)
    head.left = TreeNode(-1)
    head.left.left = TreeNode(1)
    head.left.right = TreeNode(2)
    head.right = TreeNode(3)
    # root.right.left = TreeNode(4)
    # root.right.right = TreeNode(-5)
    print(sol.max_node_2(head).val)
