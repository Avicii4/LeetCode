/**
 * Created by Harry Chou at 2018/10/29.
 * Description:Implement strStr().Return the index of the first occurrence of
 * needle in haystack, or -1 if needle is not part of haystack.
 */
public class Str {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 == 0)
            return 0;
        if (len1 < len2)
            return -1;
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.substring(i, i + len2).equals(needle))
                return i;
        }
        return -1;
    }
}