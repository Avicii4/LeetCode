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
        """
        用递归方式遍历
        """
        if root is None:
            return root
        left = self.max_node_1(root.left)
        right = self.max_node_1(root.right)
        return self.find_max(root, self.find_max(left, right))

    def find_max(self, p: TreeNode, q: TreeNode) -> TreeNode:
        if p is None:
            return q
        if q is None:
            return p
        if p is not None and q is not None:
            # 题目要求如果节点值相同，返回应该是更深的那个节点，故必须要加等于
            if p.val >= q.val:
                return p
            else:
                return q

    def max_node_2(self, root: TreeNode) -> TreeNode:
        """
        先序遍历的非递归形式的改写
        """
        if not root:
            return root
        lst, cur_max = [root], root
        while lst:
            # 这里保证深度小的节点先出栈
            p = lst.pop(0)
            if p.val >= cur_max.val:
                cur_max = p
            if p.right:
                lst.append(p.right)
            if p.left:
                lst.append(p.left)
        return cur_max


if __name__ == '__main__':
    sol = Solution()
    head = TreeNode(1)
    head.left = TreeNode(-1)
    head.left.left = TreeNode(1)
    head.left.right = TreeNode(5)
    head.right = TreeNode(5)
    head.right.left = TreeNode(-4)
    head.right.right = TreeNode(3)
    print(sol.max_node_2(head))
    print(head.left.right, head.right)
