/**
 * Created by Harry Chou at 2018/11/7.
 * Description: You are given two non-empty linked lists representing two
 * non-negative integers. The digits are stored in reverse order and each of
 * their nodes contain a single digit. Add the two numbers and return it as a
 * linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 */
public class AddTwoNumbers {
    public ListNode add(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int value1 = (l1 == null) ? 0 : l1.val;
            int value2 = (l2 == null) ? 0 : l2.val;
            int sum = carry + value1 + value2;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1)
            curr.next = new ListNode(1);
        return ans.next;
    }
}