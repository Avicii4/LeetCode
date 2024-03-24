package problems.linkedlist.反转链表;

import problems.util.ListNode;

/**
 * Created by Harry Chou at 2019/4/28.
 */

public class Reverse {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = null;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        head.next = null;
        head = p1;

        return head;
    }
}