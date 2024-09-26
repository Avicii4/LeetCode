package problems.tree;

import problems.util.TreeNode;

/**
 * Created by Harry Chou at 2019/4/14.
 * Description: Given two binary trees, write a function to check if they are
 * the same or not. Two binary trees are considered the same if they are
 * structurally identical and the nodes have the same value.
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LC100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Integer[] p = {1, 1, 2};
        Integer[] q = {1, 2, 1};
        TreeNode pTree = TreeNode.buildTree(p);
        TreeNode qTree = TreeNode.buildTree(q);
        System.out.println(isSameTree(pTree, qTree));
    }
}
