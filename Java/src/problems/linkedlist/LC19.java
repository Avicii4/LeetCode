package problems.linkedlist;

import problems.util.ListNode;

// 删除数组倒数第N个节点
public class LC19 {
    public static ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = head;
        while (n > 1) {
            fast = fast.next;
            n--;
        }
        ListNode slow = dummyHead;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;   // 注意不能返回head
    }

    public static ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++)
            first = first.next;
        if (first == null) { // 要删的是第一个节点
            head = head.next;
            return head;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode.print(head);
        ListNode.print(removeNthFromEnd_1(head,2));

    }

}
