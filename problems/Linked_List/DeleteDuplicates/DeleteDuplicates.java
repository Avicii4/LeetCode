/**
 * Created by Avicii4 at 2021/12/30.
 * Given the head of a sorted linked list, delete all duplicates
 * such that each element appears only once. Return the linked
 * list sorted as well.
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // 链表为空或仅一个结点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return p;
    }

    // 递归法
    public ListNode deleteDuplicatesRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            head = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
