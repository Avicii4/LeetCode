package problems.tree.二叉树的镜像;
/**
 * Created by Harry Chou at 2019/5/4.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import problems.util.TreeNode;

import java.util.Stack;

public class MirrorTree {
    public void mirror_1(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode currentNode = stack.pop();
                if (currentNode.left != null || currentNode.right != null) {
                    TreeNode tmpNode = currentNode.left;
                    currentNode.left = currentNode.right;
                    currentNode.right = tmpNode;
                }

                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
            }
        }
    }

    public void mirror_2(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        if (root.left != null) {
            mirror_2(root.left);
        }
        if (root.right != null) {
            mirror_2(root.right);
        }
    }
}