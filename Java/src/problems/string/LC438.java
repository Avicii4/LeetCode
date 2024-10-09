package problems.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {
    // 方法一：双指针滑动窗口，实时更新字母频率表curArr并和arr作比较（思路参考LeetCode-3）
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[26];
        int[] curArr = new int[26];
        for (char c : p.toCharArray()) {
            arr[c - 'a']++;
        }
        int n = s.length();
        int front = 0;
        while (front < n && arr[s.charAt(front) - 'a'] == 0) {
            front++;
        }
        int rear = front;
        while (rear < n) {
            int pos = s.charAt(rear) - 'a';
            if (arr[pos] == 0) {
                // 当前字符根本不在p中
                front = rear = rear + 1;
                curArr = new int[26];
            } else if (curArr[pos] < arr[pos]) {
                // rear位置的字符在p中，且数量不超
                curArr[pos]++;
                if (Arrays.equals(curArr, arr)) {   // 找到一个结果
                    res.add(front);
                    curArr[s.charAt(front) - 'a']--;
                    front++;
                }
                rear++;
            } else {
                // rear位置的字符在p中，但字符的数量太多
                curArr[s.charAt(front) - 'a']--;
                front++;
            }
        }
        return res;
    }

    // 方法二：既然是字母异位词，那么我的滑动窗口的宽度肯定是定长，所以这个写法更简洁
    public static List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            // 保证滑动窗口是定长
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        //String s = "cbaebabacd";
        String s = "abacbabc";
        String p = "abc";
        System.out.println(findAnagrams1(s, p));
        System.out.println(findAnagrams2(s, p));
    }

}
