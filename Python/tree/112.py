from Tree import TreeNode
from typing import Optional


class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if root is None:
            return targetSum == 0

        if root.left is None and root.right is None and targetSum == root.val:
            return True
        left_res, right_res = False, False
        if root.left is not None:
            left_res = self.hasPathSum(root.left, targetSum - root.val)
        if root.right is not None:
            right_res = self.hasPathSum(root.right, targetSum - root.val)
        return left_res or right_res


if __name__ == '__main__':
    levelOrder = [5, 4, 8, 11, None, 13, 4, 7, 2, None, None, None, 1]
    root = TreeNode.buildTree(levelOrder)
    print(Solution().hasPathSum(root, 22))
