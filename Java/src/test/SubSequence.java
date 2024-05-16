package test;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static List<String> subSequence(String string) {
        char[] chars = string.toCharArray();
        List<String> list = new ArrayList<>();
        int n = string.length();
        int num = 1 << n;
        for (int i = 0; i < num; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((i >> j) % 2 == 1) {
                    cur.append(chars[j]);
                }
            }
            list.add(cur.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(SubSequence.subSequence("abcd"));
    }
}
