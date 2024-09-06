package problems.dp;

import java.util.Arrays;

/**
 * 给一个长度为n的序列和一个整数x，每次可以选择序列中的一个元素，进行两种操作
 * 1. 将其从序列中删去
 * 2. 将其值加一
 * 问至少操作多少次，可以使操作后的序列(可以为空)中数字之和是x的倍数。
 */
public class ArraySumMultiple {
    public static int minOperation(int[] arr, int n, int x) {
        // dp[i][r] 表示对于数组前i个元素，需要多少次操作，它们的和对x取余后值为r
        // 我们最终要求的是dp[n][0]
        int[][] dp = new int[n + 1][x];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < x; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // 初始状态
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int a = arr[i - 1];  // 当前元素
            for (int r = 0; r < x; r++) {
                if (dp[i - 1][r] == Integer.MAX_VALUE) {
                    // 前一个状态不可达，也就是前i-1个元素无法达成对x模余r的结果，因此跳过
                    continue;
                }
                // 1. 不删除当前元素且不修改其值，更新dp[i][(r + a) % x]
                int newR = (r + a) % x;
                dp[i][newR] = Math.min(dp[i][newR], dp[i - 1][r]);

                // 2. 不删除当前元素且加一，更新dp[i][(r + a + 1) % x]
                int newRAdd = (r + a + 1) % x;
                dp[i][newRAdd] = Math.min(dp[i][newRAdd], dp[i - 1][r] + 1);

                // 3. 删除当前元素，保持余数r，操作数+1
                dp[i][r] = Math.min(dp[i][r], dp[i - 1][r] + 1);
            }

        }
        for (int[] a : dp)
            System.out.println(Arrays.toString(a));
        return dp[n][0];
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 8};
        int x = 5;
        System.out.println(minOperation(a, a.length, x));
    }
}
