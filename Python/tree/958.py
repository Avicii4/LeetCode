from Tree import TreeNode
from typing import Optional


class Solution:
    def isCompleteTree_1(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        queue = [root]
        flag = False  # 有没有遇到儿女不双全的节点
        while len(queue) > 0:
            pop_node = queue.pop(0)
            if not pop_node.left and pop_node.right:  # 左空右不空
                return False
            if not flag and (not pop_node.left or not pop_node.right):  # 儿女不双全
                flag = True
            elif flag and (pop_node.left or pop_node.right):  # 前面已经有缺口了，但本节点仍不是叶子
                return False

            if pop_node.left:
                queue.append(pop_node.left)
            if pop_node.right:
                queue.append(pop_node.right)

        return True

    def isCompleteTree_2(self, root: Optional[TreeNode]) -> bool:
        # 思路类似，但是不检查左右孩子，而是直接看是否出现过空节点
        queue = [root]
        flag = False
        while queue:
            for _ in range(len(queue)):
                pop_node = queue.pop(0)
                if not pop_node:
                    flag = True
                else:  # 当前节点非空
                    if flag:
                        # 但又出现非空节点，则不是完全二叉树
                        return False
                    queue.append(pop_node.left)
                    queue.append(pop_node.right)
        return True

    def isCompleteTree_3(self, root: Optional[TreeNode]) -> bool:
        return self.process(root)[0]

    def process(self, node):
        # 返回信息：是否是完全二叉树，是否是满二叉树，树的高度
        if not node:
            return True, True, 0

        left_info = self.process(node.left)
        right_info = self.process(node.right)

        cur_height = max(left_info[2], right_info[2]) + 1
        cur_is_full = left_info[1] and right_info[1] and left_info[2] == right_info[2]
        cur_is_complete = False
        if cur_is_full:
            # 满二叉树必为完全二叉树
            cur_is_complete = True
        elif left_info[0] and right_info[1] and left_info[2] - right_info[2] == 1:
            # 左子树是完全二叉树，右子树是满二叉树，且左子树高度比右子树大 1
            cur_is_complete = True
        elif left_info[1] and right_info[1] and left_info[2] - right_info[2] == 1:
            # 左、右子树都是满的，且左子树高度比右子树大 1
            cur_is_complete = True
        elif left_info[1] and right_info[0] and left_info[2] == right_info[2]:
            # 左子树是满二叉树、右子树是完全二叉树，且两者高度一致
            cur_is_complete = True
        return cur_is_complete, cur_is_full, cur_height
