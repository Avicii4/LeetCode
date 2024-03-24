package problems.tree;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199 {
    /**
     * 从上到下，返回从右边能看见的节点
     * 思路是层序遍历，每次返回这一层最右边的节点
     */

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        TreeNode curLevelEnd = root;
        TreeNode nextLevelEnd = null;
        List<Integer> ans = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode popNode = queue.poll();
            if (popNode.left != null) {
                queue.offer(popNode.left);
                nextLevelEnd = popNode.left;
            }
            if (popNode.right != null) {
                queue.offer(popNode.right);
                nextLevelEnd = popNode.right;
            }
            if (popNode == curLevelEnd) {
                ans.add(popNode.val);
                curLevelEnd = nextLevelEnd;
            }

        }
        return ans;

    }

    public static TreeNode buildTree() {
        TreeNode leaf1 = new TreeNode(4);
        leaf1.left=new TreeNode(999);
        TreeNode leaf2 = new TreeNode(5);
        TreeNode leaf3 = new TreeNode(6);
        TreeNode leaf4 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        node3.left = leaf3;
        node3.right = leaf4;
        node2.left = leaf1;
        node2.right = leaf2;
        TreeNode root = new TreeNode(1);
        root.left = node2;
        root.right = node3;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        LC199 sol=new LC199();
        System.out.println(sol.rightSideView(root));
    }
}
