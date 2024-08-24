package problems.linkedlist;

import problems.util.ListNode;

public class LC206 {
    // 反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        // 创建链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode.print(head);
        // 反转链表
        ListNode reversedHead = reverseList(head);
        // 打印反转后的链表
        ListNode.print(reversedHead);
    }
}
