package problems.tree.lc230;

import problems.util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Harry Chou at 2019/9/5. Updated by 2024/3/21.
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


    public int kthSmallest(TreeNode root, int k) {
        MyBST myBST = new MyBST(root);
        return myBST.kthSmallest(k);
    }

}


class MyBST {
    TreeNode root;
    Map<TreeNode, Integer> childNum;

    public MyBST(TreeNode root) {
        this.root = root;
        this.childNum = new HashMap<>();
        countNodeNum(root);
    }

    private int countNodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        childNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
        return childNum.get(node);
    }

    private int getNodeNum(TreeNode node) {
        return childNum.getOrDefault(node, 0);
    }

    public int kthSmallest(int k) {
        TreeNode node = root;
        while (node != null) {
            int left = getNodeNum(node.left);
            if (left < k - 1) {
                node = node.right;
                k -= left + 1;
            } else if (left == k - 1) {
                return node.val;
            } else {
                node = node.left;
            }
        }
        return node.val;
    }

}
