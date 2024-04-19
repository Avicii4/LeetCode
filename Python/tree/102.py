from Tree import TreeNode
from typing import Optional, List


class Solution:
    @classmethod
    def levelOrder_1(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        queue = [root]
        cur_level_nodes = []
        cur_level_end, next_level_end = root, None
        while queue:
            pop_node = queue.pop(0)
            cur_level_nodes.append(pop_node.val)

            if pop_node.left:
                queue.append(pop_node.left)
                next_level_end = pop_node.left
            if pop_node.right:
                queue.append(pop_node.right)
                next_level_end = pop_node.right

            if pop_node == cur_level_end:
                res.append(cur_level_nodes)
                cur_level_nodes = []
                cur_level_end = next_level_end

        return res

    @classmethod
    def levelOrder_2(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        queue = [root]
        while queue:
            qlen = len(queue)
            cur_level = []
            for i in range(qlen):  # 此时的qlen就是树中的这一层的节点数目
                pop_node = queue.pop(0)
                if pop_node:
                    cur_level.append(pop_node.val)
                    queue.append(pop_node.left)
                    queue.append(pop_node.right)
            res.append(cur_level)
        return res


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2, TreeNode(4), TreeNode(5))
    root.right = TreeNode(3, TreeNode(6), TreeNode(7))
    print(Solution.levelOrder_2(root))
