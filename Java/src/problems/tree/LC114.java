package problems.tree;

import problems.util.TreeNode;

import java.util.Stack;

public class LC114 {
    /**
     * 返回值是空，要求原地操作
     * 对于一个节点 node 来说：
     * 1. 若 node 左孩子不为空，那么记录一下其右子树，然后链表的下一个位置
     * 设置为直接的左孩子，然后继续到 node 的左孩子处遍历
     * 2. 若 node 左孩子空，返回上一步，进入我记录的右子树，在链表上
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = new TreeNode(-1);
//        TreeNode tmpRight=null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            cur.right = node;
            cur.left = null;
            cur = node;
            // do something
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }

    private TreeNode build() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = new TreeNode(6);
        n3.right = new TreeNode(7);
        return n1;
    }


    public static void main(String[] args) {
        LC114 s = new LC114();
        TreeNode root = s.build();
        s.flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

}
