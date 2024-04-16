package problems.tree;

import problems.util.TreeNode;

public class LC110 {
    public static boolean isBalanced(TreeNode root) {
        return processBalance(root).isBalanced;
    }

    private static Info processBalance(TreeNode node) {
        if (node == null) {
            return new Info(true, 0);
        }
        Info leftInfo = processBalance(node.left);
        Info rightInfo = processBalance(node.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced &&
                Math.abs(leftInfo.height - rightInfo.height) <= 1;
        return new Info(isBalanced, height);
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] b = {1, 2, 3, 4, null, null, 7, 8};
        TreeNode tree1 = TreeNode.buildTree(a);
        TreeNode tree2 = TreeNode.buildTree(b);
        System.out.println(isBalanced(tree1));
        System.out.println(isBalanced(tree2));
    }
}

class Info {
    boolean isBalanced;
    int height;

    public Info(boolean b, int h) {
        isBalanced = b;
        height = h;
    }
}
