package test;

import problems.util.ListNode;

public class DeleteNodeWithValue {
    public ListNode deleteNode(ListNode head, int val) {
        // 虚拟头部节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode pre = dummyHead;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next; // 跳过删除结点
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
