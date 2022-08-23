package problems.array.lc27;

/**
 * Created by Harry Chou at 2019/01/18.
 * Description: Given an array nums and a value val, remove all instances of
 * that value in-place and return the new length. Do not allocate extra space
 * for another array, you must do this by modifying the input array in-place
 * with O(1) extra memory.
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int i = 0;
        while (i < len) {
            if (nums[i] == val) {
                len--;
                nums[i] = nums[len];
            } else {
                i++;
            }
        }
        return len;
    }
}