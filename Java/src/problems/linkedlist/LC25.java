package problems.linkedlist;

import problems.util.ListNode;

public class LC25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode groupPrev = dummyNode, groupNext;
        while (true) {
            ListNode p = groupPrev;
            int idx = k;
            // 先找到本次翻转小组的末尾节点
            while (p != null && idx > 0) {
                p = p.next;
                idx--;
            }
            // 本次的翻转小组不够k个节点，可以返回了
            if (p == null) {
                break;
            }
            groupNext = p.next; // 记一下下个翻转小组的头，即本小组之后的那个节点
            // 开始翻转
            ListNode pre = p.next;
            ListNode cur = groupPrev.next;
            ListNode next;
            while (cur != groupNext) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            ListNode tmp = groupPrev.next; // 小组原来的第一个，现在是最后一个
            // 上一个小组的末尾要连接上本小组的头，本小组在翻转后的头就是p
            groupPrev.next = p;
            groupPrev = tmp;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createWithArray(new int[]{1, 2, 3, 4, 5});
        ListNode.print(head);
        ListNode.print(reverseKGroup(head, 3));
    }
}
