package problems.tree;

import problems.util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 二叉搜索树中第 K 小的元素
public class LC230 {
    // 方法一：中序遍历的非递归版本
    public static int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                k--;
                if (k == 0) {  // 此时正好弹出的节点就是第k小的
                    return cur.val;
                } else {
                    root = cur.right;
                }
            }
        }
        return -1;
    }

    // 方法二：递归得到左、右子树有多少
    public static int kthSmallest2(TreeNode root, int k) {
        int leftNodes = countNodes(root.left);
        if (leftNodes < k - 1) {
            return kthSmallest2(root.right, k - leftNodes - 1);
        } else if (leftNodes == k - 1) {
            return root.val;
        } else {
            return kthSmallest2(root.left, k);
        }
    }

    // 求以root为根的子树总共有多少节点
    private static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum + 1;
    }

    /**
     * 方法三是方法二的改进版本，因为不断调用countNodes会产生很多重复计算，
     * 因此这里新建一个树的数据结构MyBST，它用一个全局Map来存每个子树的节点数量
     * 算法逻辑和方法二是一样的，但是省一点时间
     */
    public static int kthSmallest3(TreeNode root, int k) {
        MyBST bst = new MyBST(root);
        return bst.findKthSmallest(k);
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 4, null, 2};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(kthSmallest3(root, 4));
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

    // 统计以node为根结点的子树的结点数
    private int countNodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        childNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
        return childNum.get(node);
    }

    // 获取以node为根结点的子树的结点数
    private int getNodeNum(TreeNode node) {
        return childNum.getOrDefault(node, 0);
    }

    public int findKthSmallest(int k) {
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