package problems.linkedlist;

import problems.util.ListNode;

/**
 * Created by Harry Chou at 2018/11/24.
 * Description: Given a singly linked list, determine if it is a palindrome.
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class LC234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 先找链表中点（偶数节点数就找前中点）
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p = slow.next;  // 这是要开始反转的位置
        ListNode pre = null;
        ListNode next = null;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        slow.next = null;

        // 前后比较
        boolean res = true;
        ListNode secondHalf = pre;    // 用于恢复链表
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                res = false;
            }
            head = head.next;
            pre = pre.next;
        }
        pre = null;
        while (secondHalf != null) {
            next = secondHalf.next;
            secondHalf.next = pre;
            pre = secondHalf;
            secondHalf = next;
        }

        return res;
    }
}