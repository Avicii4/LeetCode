from Tree import TreeNode
from typing import Optional


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        return self.process(root)[0]

    def process(self, node):
        if not node:
            return 0, 0

        left_diameter, left_height = self.process(node.left)
        right_diameter, right_height = self.process(node.right)

        max_height = max(left_height, right_height) + 1
        max_diameter = max(left_diameter, right_diameter, left_height + right_height)
        return max_diameter, max_height
