/**
 * Created by Harry Chou at 2019/5/2.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class HasSubtree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root2 != null && root1 != null) {
            if (root1.val == root2.val) {
                result = compareTree(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean compareTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return compareTree(node1.left, node2.left) && compareTree(node1.right, node2.right);
    }
}