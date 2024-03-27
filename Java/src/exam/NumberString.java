package exam;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * 读取一个数字字符串，例如981，输出所有的两两组合，不重复
 * 例如98,89,91,19,81,18
 */
public class NumberString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char a = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                char b = s.charAt(j);
                set.add("" + a + b);
                set.add("" + b + a);
            }
        }

        String res = String.join(",", set);
        System.out.print(res);
    }
}
