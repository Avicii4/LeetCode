package problems.array;

public class LC53 {
    public static int maxSubArray(int[] nums) {
        // 贪心算法
        // 如果curSum是负数，则它对于我们求和是一种「累赘」，因此可以直接舍弃之前的和
        int res = nums[0], curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            res = Math.max(curSum, res);
        }
        return res;
    }

    public static int maxSubArrayDP(int[] nums) {
        // 设置dp[i]为以i元素为末尾的数组的最大连续子数组和
        // 可得 dp[i] = max{dp[i-1]+nums[i], nums[i]}
        int n = nums.length;
        int[] dp = new int[n];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int maxSubArrayDPSimple(int[] nums) {
        // 因为上面的dp法中的i位置指依赖i-1位置，所以dp数组换成一个变量pre即可
        int n = nums.length;
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] arr = new int[]{5, 4, -1, 7, 8};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArrayDPSimple(arr));
    }
}
