package problems.dp;

import java.util.HashMap;
import java.util.Map;

public class LC97 {

    private Map<String, Boolean> dp;
    String s1, s2, s3;

    // 方法一：暴力的记忆化搜索
    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp = new HashMap<>();
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (dp.containsKey(i + "," + j)) {
            return dp.get(i + "," + j);
        }
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(i + 1, j)) {
            return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfs(i, j + 1)) {
            return true;
        }
        dp.put(i + "," + j, false);  // 如果上面两个if没有返回，那说明无法组成s3
        return false;
    }


    // 方法二：纯粹的自右下到左上的dp法
    public boolean isInterleave2(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(new LC97().isInterleave2(s1, s2, s3));
    }
}
