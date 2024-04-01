package problems.linkedlist;

import problems.util.ListNode;

// 两数相加，这应该是比较优雅的代码写法
public class LC2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int value1 = (l1 == null) ? 0 : l1.val;
            int value2 = (l2 == null) ? 0 : l2.val;
            int newVal = carry + value1 + value2;
            carry = newVal / 10;
            cur.next = new ListNode(newVal % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.createWithArray(new int[]{2, 9, 9});
        ListNode b = ListNode.createWithArray(new int[]{1, 2, 3});
        ListNode.print(addTwoNumbers(a, b));
    }
}
