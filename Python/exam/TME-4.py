from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def recoverHuffman(self, leaf: List[str], value: List[int]) -> TreeNode:
        lst = value
        root = TreeNode(sum(lst))
        for code in leaf:
            cur = root
            for i, ch in enumerate(code):
                if ch == '0':
                    if not cur.left:
                        if len(lst) > 2:
                            v = max(lst)
                        else:
                            v = min(lst)
                        cur.left = TreeNode(v)
                        lst.remove(v)
                else:
                    if not cur.right:
                        cur.right = TreeNode(cur.val - cur.left.val)
                    cur = cur.right
        print(root)
        return  root

a = ["0", "10", "110", "111"]
b = [3, 1, 1, 2]

Solution().recoverHuffman(a, b)
