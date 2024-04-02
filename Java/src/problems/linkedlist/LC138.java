package problems.linkedlist;

public class LC138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        Node next = null;
        while (p != null) {
            next = p.next;
            Node newNode = new Node(p.val);
            p.next = newNode;
            newNode.next = next;
            p = next;
        }

        p = head;
        Node curCopy = null;
        // 开始让复制节点的random域指向正确的节点
        while (p != null) {
            next = p.next.next;
            curCopy = p.next;
            curCopy.random = p.random == null ? null : p.random.next;
            p = next;
        }

        p = head;
        Node res = p.next;
        // 断开新旧链表
        while (p != null) {
            next = p.next.next;
            curCopy = p.next;
            p.next = next;
            curCopy.next = next == null ? null : next.next;
            p = next;
        }
        return res;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}