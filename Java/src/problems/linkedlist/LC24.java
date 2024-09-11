package problems.linkedlist;

import problems.util.ListNode;

public class LC24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next.next;
            ListNode p = cur.next, q = cur.next.next;
            p.next = next;
            q.next = p;
            cur.next = q;
            cur = p;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        ListNode p = ListNode.createWithArray(arr);
        ListNode.print(p);
        ListNode.print(swapPairs(p));

    }
}
