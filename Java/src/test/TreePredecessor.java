package test;

public class TreePredecessor {
    // 给定某个节点，返回这个节点的后继节点
    // 也就是中序遍历序列中的后一个节点
    public static TreePredecessorNode getPredecessor(TreePredecessorNode head) {
        if (head != null) {
            if (head.right != null) {
                TreePredecessorNode p = head.right;
                while (p.left != null) {
                    p = p.left;
                }
                return p;
            } else {
                while (head.parent != null && head.parent.right == head) {
                    head = head.parent;
                }
                return head.parent;
            }
        }
        return null;
    }
}


class TreePredecessorNode {
    String value;
    TreePredecessorNode left;
    TreePredecessorNode right;
    TreePredecessorNode parent;
}