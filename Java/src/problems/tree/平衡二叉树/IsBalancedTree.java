/**
 * Created by Harry Chou at 2019/6/12.
 */
public class IsBalancedTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}
