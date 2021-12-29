import java.util.HashSet;
import java.util.Set;

/**
 * Created by Harry Chou at 2018/11/8.
 * Description: Given a string, find the length of the longest substring without
 * repeating characters.
 */
public class GetLength {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int beginIndex = 0;
        int endIndex = 0;
        Set<Character> set = new HashSet<>();
        while (endIndex < s.length() && beginIndex < s.length()) {
            if (set.add(s.charAt(endIndex))) {
                set.add(s.charAt(endIndex++));
                ans = Math.max(ans, endIndex - beginIndex);
            } else {
                set.remove(s.charAt(beginIndex++));
            }
        }
        return ans;
    }
}