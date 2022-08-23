package problems.string.lc395;

/**
 * Created by Harry Chou at 2019/9/7.
 * Description: Find the length of the longest substring T of a given string (consists of lowercase letters only) 
 * such that every character in T appears no less than k times.
 */
public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        return backTrace(s, k, 0, s.length() - 1);
    }

    private int backTrace(String s, int k, int start, int end) {
        if (start > end) {
            return 0;
        }
        int[] counter = new int[26];
        // 统计词频
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            // 字母的出现次数达不到 k 的要求，则它肯定不在结果字串中
            if (counter[i] > 0 && counter[i] < k) {
                // 找到该字母位置，分治
                // 注意这里要从 start 位置开始找该字母，而不是从 s 开头
                int pos = s.indexOf((char) ('a' + i), start);
                return Math.max(backTrace(s, k, start, pos - 1), backTrace(s, k, pos + 1, end));
            }
        }
        // 字母的词频都符合 k 的要求
        return end - start + 1;
    }
}
