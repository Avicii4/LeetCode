package test;

import problems.util.ListNode;

public class SomeListNode {


    // 1. 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static ListNode midNode1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 2. 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public static ListNode midNode2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 3.输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
    public static ListNode midNode3(ListNode head) {
        // 少于两个节点都是返回空
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // 4. 输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个(即上中点)
    public static ListNode midNode4(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    // 将一个链表按照给定值划分成三个区域
    public static ListNode listPartition(ListNode head, int pivot) {
        // 划分出三个区域：小于区、等于区、大于区
        // 分别定义它们的头和尾指针
        ListNode sH = null;
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;

        ListNode next = null; // 保存下一个节点
        while (head != null) {
            next = head.next;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;  // 去下一个位置
        }

        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;  // eT==null则说明整个等于区是空的
        }
        if (eT != null) {
            eT.next = bH;
        }
        // sH是空的就要返回eH，如果eH也是空的，返回bH
        return sH != null ? sH : eH != null ? eH : bH;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println(midNode4(n1).val);
    }
}
