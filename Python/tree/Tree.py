class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    @classmethod
    def insertLevelOrder(cls, arr, root, i, n):
        # Base case for recursion
        if i < n:
            if arr[i] is None:
                return None

            temp = TreeNode(arr[i])
            root = temp

            # insert left child
            root.left = cls.insertLevelOrder(arr, root.left, 2 * i + 1, n)
            # insert right child
            root.right = cls.insertLevelOrder(arr, root.right, 2 * i + 2, n)

        return root

    @classmethod
    def buildTree(cls, levelOrder):
        n = len(levelOrder)
        return cls.insertLevelOrder(levelOrder, None, 0, n)
