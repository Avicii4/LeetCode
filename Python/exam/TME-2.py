class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
import copy

class Solution:
    def makeCompleteTree(self, root: TreeNode) -> TreeNode:
        node_dict = []
        queue = []
        queue.append(root)
        while len(queue) > 0:
            node = queue.pop()
            node_dict.append([node.left, node.right])
            if node.left:
                queue.insert(0, node.left)
            if node.right:
                queue.insert(0, node.right)
        flag = False
        hasAdd = False
        copy_dict = copy.deepcopy(node_dict)

        while True:
            for i in range(len(node_dict) - 1, -1, -1):
                elem = node_dict[i]
                if not flag and elem[0] is None and elem[1] is None:
                    continue
                if flag:
                    if elem[0] is None and elem[1] is None:
                        flag = True
                        continue
                    if elem[0] is None:
                        elem[0] = TreeNode(1)
                        hasAdd = True
                        copy_dict.insert(2 * i, [elem[0].left, elem[1].right])
                    if elem[1] is None:
                        elem[1] = TreeNode(1)
                        hasAdd = True
                        copy_dict.insert(2 * i + 1, [elem[0].left, elem[1].right])

            if not hasAdd:
                break
            else:
                node_dict = copy.deepcopy(copy_dict)
                copy_dict = copy.deepcopy(node_dict)

        print(1)
        return root

    def makeCompleteTree_12(self, root: TreeNode) -> TreeNode:
        p = root
        if p is None:
            return root
        queue = []
        queue.insert(0, p)
        wait_lst = []  #
        flag = False  # 之前是不是已有叶子节点
        while len(queue) > 0:
            p = queue.pop()
            if p.left is None and p.right is None:  # 全空
                flag = True  # 接下来应该全是叶子
                wait_lst.append(p)
            if p.left is None and p.right is not None:  # 左空右不空，肯定加节点
                p.left = TreeNode(1)
                if flag:
                    wait_lst.append(p.left)

            if flag:
                # 如果剩下的节点监测到孩子
                if p.left is not None or p.right is not None:
                    for node in wait_lst:
                        node.left = TreeNode(1)
                        node.right = TreeNode(1)

            if p.left is not None:
                queue.insert(0, p.left)
                if flag:
                    wait_lst.append(p.left)
            if p.right is not None:
                queue.insert(0, p.right)
                if flag:
                    wait_lst.append(p.right)
        return root


r = TreeNode(1)
r.right = TreeNode(1)
r.right.left = TreeNode(1)

Solution().makeCompleteTree(r)
