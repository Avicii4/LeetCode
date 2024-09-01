package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    // 本题需要结合 Leetcode169 一起看

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // 每次确定一个目标值nums[i]，另外两数之和的目标即为-nums[i]，于是转成两数之和的问题
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int p = i + 1, q = n - 1;
            while (p < q) {
                int cur = nums[p] + nums[q];
                if (cur == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[p++], nums[q]));
                    while (p < q && nums[p] == nums[p - 1]) {
                        p++;
                    }
                } else if (cur < -nums[i]) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] arr = new int[]{-6,-6, 2, 3, 3, 4};
        int[] arr = new int[]{0, 0, 0, 0};
        System.out.println(threeSum(arr));
    }
}
