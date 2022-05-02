package problems.tree.lc230;

import problems.util.TreeNode;

import java.util.Stack;

/**
 * Created by Harry Chou at 2019/9/5.
 * Description: Given a binary search tree, write a function kthSmallest
 * to find the kth smallest element in it.
 */
public class KthSmallest {
    public int findTheNode(TreeNode root, int k) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    k--;
                    if (k == 0) {
                        return root.val;
                    }
                    root = root.right;
                }
            }
        }
        return 0;
    }
}
