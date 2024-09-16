package problems.string;

import java.util.ArrayList;
import java.util.List;

// 计算一个01字符串中01平衡的子串个数，
// 且01必须是连续的，例如 0011、10、111000等
public class LC696 {
    // 比如给定00111011，得到数组[2,3,1,2]
    // 结果就是数组两两的最小值：2+1+1
    public static int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                list.add(cur);
                cur = 1;
            }
        }
        list.add(cur);
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            res += Math.min(list.get(i), list.get(i + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        String s="00110011";
        System.out.println(countBinarySubstrings(s));
    }
}
