package test;

import problems.util.TreeNode;

// 判断一棵树是否是满二叉树
public class FullBinaryTree {
    public static boolean isFull(TreeNode head) {
        int[] info = processFull(head);
        return (1 << info[1]) - 1 == info[0];
    }

    private static int[] processFull(TreeNode node) {
        // 返回第一个是节点数目，第二个是子树的高度
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = processFull(node.left);
        int[] right = processFull(node.right);
        return new int[]{left[0] + right[0] + 1, Math.max(left[1], right[1]) + 1};
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7};
        Integer[] b = {1, 2, 3, 4, 5, 6};
        TreeNode tree1 = TreeNode.buildTree(a);
        TreeNode tree2 = TreeNode.buildTree(b);
        System.out.println(isFull(tree1));
        System.out.println(isFull(tree2));
    }
}
