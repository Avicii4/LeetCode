package problems.tree.从上往下打印二叉树;
/**
 * Created by Harry Chou at 2019/5/17.
 * <p>
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class BFS {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return list;
    }
}
