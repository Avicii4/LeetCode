import java.util.Arrays;

/**
 * Created by Harry Chou at 2019/01/21.
 * Description: Given an array nums of n integers and an integer target, find
 * three integers in nums such that the sum is closest to target. Return the sum
 * of the three integers. You may assume that each input would have exactly one
 * solution.
 */

public class ClosestSum {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int front = i + 1;
            int rear = nums.length - 1;
            while (front < rear) {
                int sum = nums[i] + nums[front] + nums[rear];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                if (sum < target) {
                    front++;
                } else {
                    rear--;
                }
            }
        }
        return bestSum;
    }
}