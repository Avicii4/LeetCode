/**
 * Created by Harry Chou at 2018/11/13.
 * Description: Given an array of integers,find if the array contains any duplicates.
 */
public class ContainsDuplicate {
    public boolean findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[i] == nums[i + j])
                    return true;
            }
        return false;
    }
}