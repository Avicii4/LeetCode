from Tree import TreeNode
from typing import Optional


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        stack = [root]
        node = root.left
        while node or len(stack) > 0:
            if node:
                stack.append(node)
                node = node.left
            else:
                pop_node = stack.pop()
                k -= 1
                if k == 0:
                    return pop_node.val
                node = pop_node.right
        return -1

    # 如果需要频繁地查找第 k 小的值
    def kthSmallest_2(self, root: Optional[TreeNode], k: int) -> int:
        bst = MyBst(root)
        return bst.kth_smallest(k)


class MyBst:
    def __init__(self, root: TreeNode):
        self.root = root

        # 统计以每个结点为根结点的子树的结点数，并存储在哈希表_node_num中
        self._node_num = {}
        self._count_node_num(root)

    def kth_smallest(self, k: int):
        """
        返回二叉搜索树中第k小的元素
        1. 如果 node 的左子树的结点数 left 小于 k−1，则第 k 小的元素一定在 node 的右子树中，
        令 node 等于其的右子结点，k 等于 k−left−1，并继续搜索；
        2. 如果 node 的左子树的结点数 left 等于 k−1，则第 k 小的元素即为 node，结束搜索并返回；
        3. 如果 node 的左子树的结点数 left 大于 k−1，则第 k 小的元素一定在 node 的左子树中，
        令 node 等于其左子结点，并继续搜索。
        """
        node = self.root
        while node:
            left = self._get_node_num(node.left)
            if left < k - 1:
                node = node.right
                k -= left + 1
            elif left == k - 1:
                return node.val
            else:
                node = node.left

    def _count_node_num(self, node) -> int:
        """统计以node为根结点的子树的结点数"""
        if not node:
            return 0
        self._node_num[node] = 1 + self._count_node_num(node.left) + self._count_node_num(node.right)
        return self._node_num[node]

    def _get_node_num(self, node) -> int:
        """获取以node为根结点的子树的结点数"""
        return self._node_num[node] if node is not None else 0


def insert_into_bst(root, val):
    if root is None:
        return TreeNode(val)
    if val < root.val:
        root.left = insert_into_bst(root.left, val)
    elif val > root.val:
        root.right = insert_into_bst(root.right, val)
    return root


if __name__ == '__main__':
    values = [5, 3, 6, 2, 4, None, None, 1]
    root = None
    for val in values:
        if val is not None:
            root = insert_into_bst(root, val)
    print(Solution().kthSmallest(root, 1))
    print(Solution().kthSmallest(root, 2))
    print(Solution().kthSmallest(root, 3))
    print(Solution().kthSmallest(root, 4))
    print(Solution().kthSmallest(root, 5))
    print(Solution().kthSmallest(root, 6))
