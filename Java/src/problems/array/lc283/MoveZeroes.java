package problems.array.lc283;

/**
 * Created by Harry Chou at 2018/10/16.
 * Description: Given an array nums, write a function to move all 0's to the end
 * of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {
    public void move(int[] nums) {
        int zeroCount = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount++;
            else {
                nums[k] = nums[i];
                k++;
            }
        }
        while (zeroCount > 0) {
            nums[nums.length - zeroCount] = 0;
            zeroCount--;
        }
    }
}