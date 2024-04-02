package test;

import problems.util.ListNode;

/**
 * 如果两个链表相交，请返回相交的第一个节点。如果不相交，返回 Null。
 * 这里完整实现各种情况
 */
public class CrossedLinkedList {

    // 如果有环，返回第一个入环的节点；否则返回空
    public static ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == head) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                // 能走到空，肯定是无环的
                return null;
            }
            slow = head.next;
            fast = head.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    // 两个链表都是无环
    public static ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        // 让cur1在较长链表上遍历，cur2在较短链表上遍历
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


    // 两链表都有环
    public static ListNode bothLoop(ListNode head1, ListNode head2, ListNode loop1, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        if (loop1 == loop2) { // 入环位置一样时，处理方法和noLoop()一样
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;//谁长谁是cur1
            cur2 = cur1 == head1 ? head2 : head1; //谁短谁是cur2
            n = Math.abs(n);
            while (n != 0) {
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            // 如果loop1和loop2不同，
            // 那么从loop1开始在环里遍历，如果能遇到loop2，说明两链表相交
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;  // 返回谁都行，都算两链表的交点
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    // 主方法
    public static ListNode getIntersectedNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, head2, loop1, loop2);
        }
        return null;
    }


}
