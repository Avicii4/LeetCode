package problems.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Tree structure
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrder[0]);
        queue.offer(root);

        int index = 1; // 从数组的第二个元素开始遍历
        while (!queue.isEmpty() && index < levelOrder.length) {
            TreeNode node = queue.poll();

            // 添加左子节点
            if (levelOrder[index] != null) {
                node.left = new TreeNode(levelOrder[index]);
                queue.offer(node.left);
            }
            index++;

            // 添加右子节点
            if (index < levelOrder.length && levelOrder[index] != null) {
                node.right = new TreeNode(levelOrder[index]);
                queue.offer(node.right);
            }
            index++;
        }

        return root;
    }

}
