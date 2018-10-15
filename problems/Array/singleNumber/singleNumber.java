/**
 * Created by Harry Chou at 2018/10/14
 * Description: Given a non-empty array of integers, every element appears twice
 * except for one. Find that single one.
 */
public class singleNumber {
    public int findSingleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                i++;
            else
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}