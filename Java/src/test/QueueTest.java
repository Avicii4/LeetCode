package test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        System.out.println(queue.isEmpty());
        queue.offer(90);
        queue.offer(88);
        System.out.println(queue.poll());
        System.out.println(queue.peek());

    }
}
