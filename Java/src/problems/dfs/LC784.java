package problems.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC784 {

    public static List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        process("", 0, s, res);
        return res;
    }

    private static void process(String cur, int idx, String s, List<String> res) {
        if (idx == s.length()) {
            res.add(cur);
            return;
        }
        char ch = s.charAt(idx);
        if (ch >= 'A' && ch <= 'z') {
            process(cur + ch, idx + 1, s, res);
            process(cur + (char) (ch ^ 32), idx + 1, s, res);  // 大小写转换的炫技写法
        } else {
            process(cur + ch, idx + 1, s, res);
        }
    }

    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }

}
