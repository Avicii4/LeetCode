package problems.tree;

import problems.util.TreeNode;

import java.util.Map;

public class LC124 {

    int res;

    public int maxPathSum(TreeNode root) {
        res = root.val;
        process(root);
        return res;
    }

    // 返回从当前节点到出发的单链路径的最大值(必须包含当前节点！)
    private int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = process(root.left);
        int rightMax = process(root.right);
        leftMax = Math.max(0, leftMax);
        rightMax = Math.max(0, rightMax);
        // 必须加上当前节点的值
        res = Math.max(res, leftMax + root.val + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        //Integer[] arr= new Integer[]{-10,9,20,null,null,15,7};
        Integer[] arr = new Integer[]{-2};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(new LC124().maxPathSum(root));
    }
}

