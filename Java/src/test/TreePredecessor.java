package test;

public class TreePredecessor {
    // 给定某个节点，返回这个节点的后继节点
    // 也就是中序遍历序列中的后一个节点
    public static Node getPredecessor(Node head) {
        if (head != null) {
            if (head.right != null) {
                Node p = head.right;
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


class Node {
    String value;
    Node left;
    Node right;
    Node parent;
}