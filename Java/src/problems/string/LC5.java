package problems.string;

// 求字符串的最长回文子串
public class LC5 {
    public static String longestPalindrome(String s) {
        int curMax = 0;
        int mLeft = 0, mRight = 0;
        int n = s.length();
        // dp[i][j]表示字符串子串i~j是否为回文串
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 如果 i+1~j-1是回文，且 [i]==[j]
                    // 那么 i~j也是回文
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
        return s.substring(mLeft, mRight + 1);
    }

    public static void main(String[] args) {
        String s = "ababd";
        System.out.println(longestPalindrome(s));
    }
}

