package problems.string;

// 给定一个字符串 s，找到它的第一个不重复的字符(只包含小写字母)
public class LC387 {
    public static int firstUniqChar(String s) {
        int[] counter = new int[26];
        // 第一遍存频率
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        int res = -1;
        // 第二遍看是不是频率为1
        for (int i = 0; i < s.length(); i++) {
            if (counter[s.charAt(i) - 'a'] == 1) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
