package problems.util;


/**
 * Definition of ListNode
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createWithArray(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void print(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            System.out.print(curr.val + " → ");
            curr = curr.next;
        }
        System.out.println(curr.val);
    }
}
