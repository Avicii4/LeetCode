/**
 * Description: Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its
 * sum.
 */
public class MaxSub {
    public int solution_1(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) // in case all the elements are negative
                result = result > nums[i] ? result : nums[i];
            sum += nums[i];
            if (sum > result)
                result = sum;
            if (sum < 0)
                sum = 0;
        }
        return result;
    }

    public int solution_2(int[] nums) {
        int sum = nums[0];
        int tempSum  = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempSum > 0)
                tempSum += nums[i];
            else
                tempSum = nums[i];
            if (sum < tempSum)
                sum = tempSum;
        }
        return sum;
    }
}