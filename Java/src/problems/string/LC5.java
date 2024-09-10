package problems.string;

public class LC5 {
    public static String longestPalindrome(String s) {
        int curMax = 0;
        int mLeft = 0, mRight = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (dp[i + 1][j - 1] || j - i < 3) {
                        dp[i][j] = true;
                        if (curMax < j - i + 1) {
                            curMax = j - i + 1;
                            mLeft = i;
                            mRight = j;
                        }
                    }
                }

            }

        }
        return s.substring(mLeft,mRight+1);
    }

    public static void main(String[] args) {
        String s = "ababd";
        System.out.println(longestPalindrome(s));
    }
}
