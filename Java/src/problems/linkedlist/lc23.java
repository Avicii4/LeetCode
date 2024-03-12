package problems.linkedlist;

import problems.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc23 {

}


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode l: lists){
            if(l!=null){
                q.offer(l);
            }
        }
        ListNode dummy=new ListNode();
        ListNode start=dummy;
        while(!q.isEmpty()){
            ListNode popNode=q.poll();
            start.next=popNode;
            start=start.next;
            if(popNode.next!=null){
                q.offer(popNode.next);
            }
        }
        return dummy.next;

    }
}