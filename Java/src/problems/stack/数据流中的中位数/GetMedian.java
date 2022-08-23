/**
 * Created by Harry Chou at 2019/7/23.
 */

import java.util.PriorityQueue;

public class GetMedian {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    int counter = 0;

    public void Insert(Integer num) {
        if ((counter & 1) == 0) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        counter++;
    }

    public Double GetMedian() {
        if ((counter & 1) == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return 1.0 * maxHeap.peek();
        }
    }

}
