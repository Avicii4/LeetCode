from Tree import TreeNode
from typing import Optional, List


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        return self.process(nums, 0, len(nums) - 1)

    def process(self, nums, left, right):
        if left == right:
            return TreeNode(nums[left])
        if left > right:
            return None
        mid = (left + right) >> 1
        head = TreeNode(nums[mid])
        head.left = self.process(nums, left, mid - 1)
        head.right = self.process(nums, mid + 1, right)
        return head

    def inorder(self, root):
        if root:
            self.inorder(root.left)
            print(root.val, end=' ')
            self.inorder(root.right)


if __name__ == '__main__':
    s = Solution()
    root = s.sortedArrayToBST([-10, -3])
    s.inorder(root)
