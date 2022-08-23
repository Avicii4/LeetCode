/**
 * Created by Harry Chou at 2019/7/17.
 */
public class EntryNodeOfLoop {
    public ListNode find (ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode p1 = pHead.next;
        ListNode p2 = pHead.next.next;
        while (p1 != p2) {
            if (p2.next == null || p2.next.next == null) {
                // 该情况即为无环
                return null;
            }
            p2 = p2.next.next;
            p1 = p1.next;
        }
        p2 = pHead;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
