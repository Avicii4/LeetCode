package problems.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Harry Chou at 2018/10/16.
 * Description: Given an array of integers, return indices of the two numbers
 * such that they add up to a specific target.
 */
public class LC1 {
    public static int[] findTwoSum(int[] nums, int target) {
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

    // 使用 HashMap 一次遍历，在插入该数前先去 HashMap 中查找有没有另外一个数，
    // 若有就可以直接返回了；若没有再插入，继续迭代。
    public static int[] twoSum(int[] nums, int target) {
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

    public static void main(String[] args) {
        int[] arr = {2, 0, 9, 10, 11};
        int target = 11;
        System.out.println(Arrays.toString(twoSum(arr, target)));

    }
}
