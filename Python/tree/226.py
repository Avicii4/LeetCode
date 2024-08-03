from typing import Optional
from Tree import TreeNode


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None

        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)

        return root


if __name__ == '__main__':
    node1 = TreeNode(1)
    node2 = TreeNode(2)
    node3 = TreeNode(3)
    node4 = TreeNode(4)

    node1.left = node2
    node1.right = node3
    node2.right = node4
    # node1.left,node1.right=node1.right,node1.left
    Solution().invertTree(node1)
    print(node1.left.val, node1.right.val, node2.left.val)
