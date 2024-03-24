package problems.tree.二叉搜索树与双向链表;
/**
 * Created by Harry Chou at 2019/5/22.
 */
import java.util.Stack;

import problems.util.TreeNode;

public class ConvertTreeNode {
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (isFirst) {
                pRootOfTree = cur;
                pre = pRootOfTree;
                isFirst = false;
            } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
        return pRootOfTree;
    }
}

class ConvertRecur {
    TreeNode pre = null;
    TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        if (pre != null) {
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        head = head == null ? pRootOfTree : head;
        Convert(pRootOfTree.right);
        return head;
    }
}
