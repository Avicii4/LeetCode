package problems.tree;

import problems.util.TreeNode;

// 计算从根节点到叶节点生成的所有数字之和
public class LC129 {
    public static int sumNumbers(TreeNode root) {
        return process(0, root);
    }

    private static int process(int cur, TreeNode curNode) {
        if (curNode == null) {
            return 0;
        }
        cur = cur * 10 + curNode.val;
        if (curNode.left == null && curNode.right == null) {
            return cur;
        }
        return process(cur, curNode.left) + process(cur, curNode.right);
    }

    public static void main(String[] args) {
        Integer[] arr = {4, 9, 0, 5, 1};
        //Integer[] arr = {0, 9, 0, 1};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(sumNumbers(root));
    }
}
