from Tree import TreeNode
from typing import Optional


class Solution:
    def isSymmetric_1(self, root: Optional[TreeNode]) -> bool:
        return self.check(root, root)

    def check(self, p, q):
        if p is None and q is None:
            return True
        if p is None or q is None:
            return False
        return p.val == q.val and self.check(p.left, q.right) and self.check(q.left, p.right)

    # 队列每次进两个节点，弹出也是同时弹两个
    def isSymmetric_2(self, root: Optional[TreeNode]) -> bool:
        queue = []
        if not root:
            return True
        queue.append(root.left)
        queue.append(root.right)
        while queue:
            p, q = queue.pop(0), queue.pop(0)
            if (p and q) and (p.val==q.val):
                queue.append(p.left)
                queue.append(q.right)
                queue.append(p.right)
                queue.append(q.left)
            elif p is None and q is None:
                continue
            else:
                return False
        return True
