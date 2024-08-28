package problems.tree;

import problems.util.TreeNode;

import java.util.LinkedList;

public class LC104 {
    // 二叉树最大高度，递归
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int getDepthWithoutRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur, last;
        int level = 0;
        while (!queue.isEmpty()) {
            // 记录本层已经遍历的节点个数
            cur = 0;
            // 当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
            last = queue.size();
            // 当还没有遍历到本层最后一个节点时循环
            while (cur < last) {
                // 出队一个元素
                current = queue.poll();
                cur++;
                // 把当前节点的左右节点入队（如果存在的话）
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // 每遍历完一层level+1
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, null, null, 7, 8};
        TreeNode root = TreeNode.buildTree(a);
        System.out.println(maxDepth(root));
        System.out.println(getDepthWithoutRecur(root));
    }

}
