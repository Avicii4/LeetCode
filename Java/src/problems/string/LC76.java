package problems.string;

import java.util.HashMap;
import java.util.Map;

public class LC76 {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        // 把t串完整记入map中
        for (char c : t.toCharArray()) {
            tMap.put(c, 1 + tMap.getOrDefault(c, 0));
        }
        int have = 0;   // 目前窗口内有多少种类的字母（不包括t串中不需要的字母）
        int need = tMap.size();  // 我需要多少种类的字母
        int p = 0, q = 0; // 窗口的双指针
        String res = "";
        boolean flag = false;  // 本次是缩窗口(p++)还是扩窗口(q++)

        while ((!flag && q < s.length()) || (flag && p <= q)) {
            if (!flag) {
                char cur = s.charAt(q);
                if (tMap.containsKey(cur)) {
                    sMap.put(cur, 1 + sMap.getOrDefault(cur, 0));
                    if (sMap.get(cur).equals(tMap.get(cur))) {  // sMap数量正好一致，才会导致have++
                        have++;
                        if (have == need) {  // have增长后，当前窗口已经覆盖了
                            flag = true;  // 下次循环可以开始缩了
                            String tmp = s.substring(p, q + 1);
                            if (res.isEmpty()) {
                                res = tmp;
                            } else {
                                res = res.length() > tmp.length() ? tmp : res;
                            }
                        }
                    }
                }
                q++;
            } else {
                // 本次是缩窗口
                char cur = s.charAt(p);
                p++;
                if (tMap.containsKey(cur)) {
                    sMap.put(cur, sMap.get(cur) - 1);
                    // 假如缩了窗口后字母不够覆盖了
                    if (sMap.get(cur) < tMap.get(cur)) {
                        have--;
                        flag = false;  // 下次要扩大窗口了
                    }
                }
                if (have == need) {
                    String tmp = s.substring(p, q);
                    res = res.length() > tmp.length() ? tmp : res;
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "bba";
        String t = "ab";
        System.out.println(minWindow(s, t));
    }
}
