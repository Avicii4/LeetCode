/**
 * Created by Harry Chou at 2018/11/24.
 * Description: Given a singly linked list, determine if it is a palindrome.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode last = slow.next;
        ListNode pre = head;
        while (last.next != null) {
            ListNode temp = last.next;
            last.next = temp.next;
            temp.next = slow.next;
            slow.next = temp;
        }
        while (slow.next != null) {
            slow = slow.next;
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
        }
        return true;
    }
}