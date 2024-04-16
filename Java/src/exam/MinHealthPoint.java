package exam;

import java.util.Scanner;

public class MinHealthPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            scanner.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[][] dp = new int[m][n];
        int minValue = arr[0][0];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int maxFromLeft = dp[i][j - 1];
                int maxFromUp = dp[i - 1][j];
                dp[i][j] = Math.max(maxFromLeft, maxFromUp) + arr[i][j];
                if (arr[i - 1][j] > arr[i][j - 1]) {
                    minValue = Math.min(minValue, dp[i - 1][j]);
                } else {
                    minValue = Math.min(minValue, dp[i][j - 1]);
                }
            }
        }
        minValue = Math.min(minValue, dp[m - 1][n - 1]);
        //System.out.println(dp[m-1][n-1]);
        if (minValue >= 0) {
            System.out.println(1);
        } else {
            System.out.println(Math.abs(minValue) + 1);
        }

    }
}
