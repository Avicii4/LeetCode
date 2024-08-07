package problems.linkedlist.从尾到头打印链表;

/**
 * Created by Harry Chou at 2019/4/15.
 * 
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */

import problems.util.ListNode;

import java.util.ArrayList;

public class ListOutput {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}