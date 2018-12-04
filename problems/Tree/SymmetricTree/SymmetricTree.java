/**
 * Created by Harry Chou at 2018/12/3.
 * Description: Given a binary tree, check whether it is a mirror of itself (ie,
 * symmetric around its center).
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isNodeSymmetric(root.left, root.right);
        }
    }

    public boolean isNodeSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return (p.val == q.val) && isNodeSymmetric(p.left, q.right) && isNodeSymmetric(p.right, q.left);
        }
    }
}