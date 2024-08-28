package problems.array;

import java.util.PriorityQueue;

public class LC215 {
    // 设置小根堆，大小固定是k，如果新来的数字大于堆顶，则淘汰堆顶，最后堆顶就是第K大的元素
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return -1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (priorityQueue.size() >= k) {
                if (num > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            }else {
                priorityQueue.add(num);
            }
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 6));
    }
}
