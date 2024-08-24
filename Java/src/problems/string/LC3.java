package problems.string;

import java.util.HashSet;
import java.util.Set;

public class LC3 {
    // 无重复字符的最长子串
    // 使用集合存储连续的子串字符
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int front = 0, rear = 0;
        Set<Character> set = new HashSet<>();
        int res = 0;
        while (front < n && rear < n) {
            if (!set.contains(s.charAt(rear))) {
                set.add(s.charAt(rear++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(front++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(a));
    }

}
