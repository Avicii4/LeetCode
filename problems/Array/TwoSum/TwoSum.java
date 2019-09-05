/**
 * Created by Harry Chou at 2018/10/16.
 * Description: Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 */
public class TwoSum {
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

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int anotherNum = target - nums[i];
            if (map.containsKey(anotherNum) && map.get(anotherNum) != i) {
                return new int[]{map.get(anotherNum), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
