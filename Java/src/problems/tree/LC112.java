package problems.tree;

import problems.util.TreeNode;

public class LC112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return process(root, 0, targetSum);
    }

    private boolean process(TreeNode node, int curSum, int targetSum) {
        curSum += node.val;
        // 如果是叶子节点，判断当前路径的和是否等于目标和
        if (node.left == null && node.right == null) {
            return curSum == targetSum;
        }
        // 递归处理左子树
        if (node.left != null && process(node.left, curSum, targetSum)) {
            return true;
        }
        // 递归处理右子树
        if (node.right != null && process(node.right, curSum, targetSum)) {
            return true;
        }
        return false;
    }

    // 方法一样，但是写法精炼一点
    public boolean hasPathSum_2(TreeNode root, int targetSum) {
        // 如果根节点为空，直接返回false
        if (root == null) return false;
        // 如果当前节点是叶子节点（即左右子节点都为空），检查路径和是否等于目标值
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        // 如果当前节点不是叶子节点，递归地在左子树和右子树中查找路径
        // 路径和等于目标值减去当前节点的值
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
