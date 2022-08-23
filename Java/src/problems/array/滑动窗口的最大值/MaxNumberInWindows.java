/**
 * Created by Harry Chou at 2019/7/23.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxNumberInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return list;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            int begin = i - size + 1;
            if (deque.isEmpty()) {
                deque.add(i);
            }
            if (begin > deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if (begin >= 0) {
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;
    }
}
