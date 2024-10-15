package problems.linkedlist;

import problems.util.ListNode;

public class LC61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }
        fast = head;
        int n = k % len;
        if (n == 0) {
            return head;
        }
        // 找倒数第k+1个节点
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode h = ListNode.createWithArray(arr);
        ListNode nh = rotateRight(h, 7);
        ListNode.print(nh);
    }
}
