package problems.array;

import java.util.Arrays;

/**
 * Created by Harry Chou at 2019/6/2.
 */
public class LCR164 {
    public static String crackPassword(int[] password) {
        String[] strings = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            strings[i] = password[i] + "";
        }
        Arrays.sort(strings, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = {0, 3, 30, 34, 5, 9};
        System.out.println(crackPassword(a));
    }
}
