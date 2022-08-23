
/**
 * Created by Harry Chou at 2019/5/27.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetSmallestNumbers {
    public ArrayList<Integer> getNum(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}