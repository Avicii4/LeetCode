/**
 * Created by Harry Chou at 2018/10/16.
 * Description: Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 */
public class twoSum {
    public int[] findTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[j] == target - nums[i])
                    if (i != j) {
                        result[0] = i;
                        result[1] = j;
                    }
        return result;
    }
}