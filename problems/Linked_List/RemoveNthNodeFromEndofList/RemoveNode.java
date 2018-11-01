/**
 * Created by Harry Chou at 2018/11/1/
 * Description: Given a linked list, remove the n-th node from the end of list
 * and return its head.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++)
            first = first.next;
        if (first == null) {
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
}