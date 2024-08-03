from typing import Optional
from Tree import TreeNode


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        if root is None:
            return 0
        # 由于路径可以不从根部开始，所以从任意节点开始DFS
        return (self.process(root, targetSum) +
                self.pathSum(root.left, targetSum) +
                self.pathSum(root.right, targetSum))

    def process(self, root, targetSum):
        if root is None:
            return 0
        cur = 1 if root.val == targetSum else 0
        # 无论当前是否找到了路径，都要继续往下，因为可能出现 target->x->-x 这种路径
        l = self.process(root.left, targetSum - root.val)
        r = self.process(root.right, targetSum - root.val)
        return cur + l + r

    def pathSum_2(self, root: Optional[TreeNode], targetSum: int) -> int:
        # 使用字典记录前缀和
        self.map = {0: 1}
        self.res = 0
        self.dfs(root, targetSum, 0)
        return self.res

    def dfs(self, root, targetSum, prefixSum):
        if root is None:
            return
        prefixSum += root.val
        interval = prefixSum - targetSum
        self.res += self.map.get(interval, 0)
        self.map[prefixSum] = self.map.get(prefixSum, 0) + 1

        self.dfs(root.left, targetSum, prefixSum)
        self.dfs(root.right, targetSum, prefixSum)
        # dfs的末尾要回溯
        self.map[prefixSum] -= 1


if __name__ == '__main__':
    levelOrder = [10, 3, -9, -3, 7, 9, 6, 10]
    root = TreeNode.buildTree(levelOrder)
    print(Solution().pathSum_2(root, 10))
