package problems.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 字符串是否可以被词典中的单词组成
public class LC139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];  // dp[i]表示 s[0]~s[i-1] 是否可以被组成
        dp[0] = true;
        for (int i = 1; i <= n; i++) {  // dp[]要填到n位置
            for (int j = 0; j < i; j++) {  // j从0开始遍历到i-1位置
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> dict = Arrays.asList("apple", "pen");
        System.out.println(wordBreak(s, dict));
    }
}
