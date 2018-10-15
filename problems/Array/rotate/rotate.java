/**
 * Created by Harry Chou at 2018/10/13. 
 * Description: Given an array, rotate the array to the right by k steps, where
 * k is non-negative.
 */
public class rotate {
    public void Solution_1(int[] nums, int k) {
        // space complexity O(1)
        int mark = 0; // move the last element to the first place
        while (k > 0) {
            mark = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--)
                nums[i + 1] = nums[i];
            nums[0] = mark;
            k--;
        }
    }

    public void Solution_2(int[] nums, int k) {
        int[] result = nums.clone();
        for (int i = 0; i < nums.length; i++)
            nums[(i + k) % nums.length] = result[i];
    }

}