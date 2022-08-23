package problems.tree.lc98;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry Chou at 2018/11/29.
 * Description: Given a binary tree, determine if it is a valid binary search
 * tree (BST).
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}