package problems.array;

import java.util.*;

public class LC239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 队列存下标，且保证下标对应数组中的值是递减的
        LinkedList<Integer> queue = new LinkedList<>();
        // 先加入前k个数字
        for (int i = 0; i < k; i++) {
            // 如果新加的元素nums[i]大于队列最后一个值，则删除队列最后一个值
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);   // 新数字加到队列末尾
        }
        int[] res = new int[n - k + 1];
        res[0] = nums[queue.peekFirst()];
        for (int i = k; i < n; i++) {
            // 如果新加的元素nums[i]大于队列
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (queue.get(0) <= i - k) {
                // 队列头部的位置
                queue.removeFirst();
            }
            res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 1)));
    }
}
