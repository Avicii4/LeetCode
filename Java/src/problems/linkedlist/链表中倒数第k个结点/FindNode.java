/**
 * Created by Harry Chou at 2019/4/28.
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindNode {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int firstStep = k - 1;
        while (firstStep > 0) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
            firstStep--;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}