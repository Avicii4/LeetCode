package problems.array;

import java.util.Arrays;

public class LC300 {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // dp数组从尾到头来填
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // i位置向后开始搜索，如果搜到了一个更大的值，那么可以得到一个dp[j]+1长度的递增序列
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(arr));
    }
}
