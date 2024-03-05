package problems.array.lc26;

/**
 * Created by Harry Chou at 2018/10/11.
 * Description: Given a sorted array nums, remove the duplicates in-place such
 * that each element appear only once and return the new length.
 */
public class RemoveDuplicates {
    public int remove(int[] nums) {
        int flag = 0;
        if (nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[flag]) {
                flag++;
                nums[flag] = nums[i];
            }
        }
        return ++flag;
    }
}

