from Tree import TreeNode
from typing import Optional


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.process(root)[0]

    def process(self, node):
        # 所有节点返回三个信息，以其为根的子树是否为BST，最大值，最小值
        if not node:
            return True, None, None

        left_info = self.process(node.left)
        right_info = self.process(node.right)

        max_val, min_val = node.val, node.val
        if left_info[1] is not None:
            max_val = max(left_info[1], max_val)
        if left_info[2] is not None:
            min_val = min(left_info[2], min_val)
        if right_info[1] is not None:
            max_val = max(right_info[1], max_val)
        if right_info[2] is not None:
            min_val = min(right_info[2], min_val)

        is_bst = True
        if left_info[0] and right_info[0]:
            if left_info[1] is not None and left_info[1] >= node.val:
                is_bst = False
            if right_info[2] is not None and right_info[2] <= node.val:
                is_bst = False
        else:
            is_bst = False

        return is_bst, max_val, min_val

    def isValidBST_2(self, root: Optional[TreeNode]) -> bool:

        def valid(node, left, right):
            """
            递归检查是否是BST
            :param node: 当前节点
            :param left: 当前节点应该大于这个值
            :param right: 当前节点应该小于这个值
            :return:
            """
            if not node:
                return True
            if not (left < node.val < right):
                return False

            return (valid(node.left, left, node.val) and
                    valid(node.right, node.val, right))

        return valid(root, float('-inf'), float('inf'))


if __name__ == '__main__':
    n1 = TreeNode(1)
    n1.left = TreeNode(0)
    n1.right = TreeNode(0)
    print(Solution().isValidBST(n1))
