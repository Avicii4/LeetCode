
/**
 * Created by Harry Chou at 2019/5/21.
 * Defination of random list node:
 * public class RandomListNode {
 *   int label;
 *   RandomListNode next = null;
 *   RandomListNode random = null;
 *
 *   RandomListNode(int label) {
 *       this.label = label;
 *   }
 * }
 */
import java.util.HashMap;

public class CloneRandomListNode {
    public RandomListNode clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }

    public RandomListNode cloneWithoutExtraSpace(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        RandomListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        cur = pHead;
        RandomListNode curCopy = null;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }
        cur = pHead;
        RandomListNode res = pHead.next;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next == null ? null : next.next;
            cur = cur.next;
        }
        return res;
    }
}
