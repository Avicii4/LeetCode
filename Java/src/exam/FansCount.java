package exam;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 首先输入数组长度n，然后是目标值x
 * 之后输入数组的所有n个元素
 * 现在想要求数组和来达到目标值x，有两种方式：
 * 1. 取某个数组元素的一半（向下取整）
 * 2. 取某个数组元素（全部）
 * 问最少需要多少个元素才可以求和得x
 * <p>
 * 示例：
 * 5 8
 * 1 2 3 4 10
 * 输出：2
 */

public class FansCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.nextLine();
        int[] fans = new int[n + 1];
        fans[0] = 0;
        for (int i = 1; i <= n; i++) {
            fans[i] = scanner.nextInt();
        }
        int[][][] dp = new int[n + 1][x + 1][2];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < x + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE - 1;
                }
            }
        }
        //Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0][0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                    if (j >= fans[i] / 2) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - fans[i] / 2][k] + 1);
                    }
                    if (j >= fans[i] && k > 0) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - fans[i]][k - 1] + 1);
                    }
                }
            }
        }
        int res = Math.min(dp[n][x][0], dp[n][x][1]);
        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }

    }


    private static int minCount(int[] arr, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int num : arr) {
                if (i - num >= 0 && dp[i - num] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }
}
