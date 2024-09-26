package problems.tree;

import problems.util.TreeNode;

import java.util.Stack;

public class LC99 {
    // 思路是找到序列中的的两个节点x和y，x比后置节点大，y比前直接点小
    public static void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;  // 中序遍历的上一个节点
        TreeNode x = null, y = null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre != null && cur.val < pre.val) {
                    // 如果发现当前节点值小于之前的值，用y记录当前节点
                    y = cur;
                    if (x == null) {
                        x = pre;  // 第一次出现错误情况（即当前节点值小于之前的值），那就记下pre
                    } else {
                        break;   // 第二次出现错误情况，那么我们两个节点都找齐了，可以退出循环了
                    }
                }
                pre = cur;
                cur = cur.right;
            }
        }
        swap(x, y);
    }


    private static void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    public static void main(String[] args) {
        Integer[] arr = {7, 2, 6, 1, 3, 5, 4};
        // 中序遍历是 1 2 3 7 5 6 4，思路是找到序列中的的两个节点x和y，x比后置节点大，y比前直接点小
        TreeNode root = TreeNode.buildTree(arr);
        recoverTree(root);

    }
}
