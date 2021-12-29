import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Harry Chou at 2018/11/4.
 * Description: Given an array nums of n integers, are there elements a, b, c in
 * nums such that a + b + c = 0? Find all unique triplets in the array which
 * gives the sum of zero.
 */
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 3)
            return result;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> elem = Arrays.asList(nums[i], nums[k], nums[j]);
                    result.add(elem);
                    while (j < k && nums[j] == nums[j + 1])
                        j++;
                    while (k > j && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                } else if (sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return result;
    }
}