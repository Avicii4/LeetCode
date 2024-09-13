package exam;

import java.util.Arrays;

public class Tuhu1 {
    public static int maxPriceValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 第一行的初始化
        for (int j = 1; j < n; j++) {
            if (grid[0][j] == -1) {
                dp[0][j] = -1;
            } else if (dp[0][j - 1] != -1) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            } else {
                dp[0][j] = -1;
            }
        }

        // 第一列的初始化
        for (int i = 1; i < m; i++) {
            if (grid[i][0] == -1) {
                dp[i][0] = -1;
            } else if (dp[i - 1][0] != -1) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            } else {
                dp[i][0] = -1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == -1) {
                    dp[i][j] = -1;
                } else {
                    int fromTop = dp[i - 1][j];
                    int fromLeft = dp[i][j - 1];
                    if (fromTop == -1 && fromLeft == -1) {
                        dp[i][j] = -1;
                    } else if (fromTop == -1) {
                        dp[i][j] = grid[i][j] + fromLeft;
                    } else if (fromLeft == -1) {
                        dp[i][j] = grid[i][j] + fromTop;
                    } else {
                        dp[i][j] = Math.max(fromTop, fromLeft) + grid[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));

        }
        return dp[m - 1][n - 1] == -1 ? 0 : dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        maxPriceValue(arr);
    }

}
