package exam;

import java.util.Scanner;

// 有n个字符串，每次从中各取一个组成一个字符串，
// 要求组成的串不能有连续相同字符，问符合要求的字符串个数
public class Problem4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        int mod = 1000000007;
        int res = 0;
        if (n == 2) {
            for (int i = 0; i < strings[0].length(); i++) {
                for (int j = 0; j < strings[1].length(); j++) {
                    String s = "" + strings[0].charAt(i) + strings[1].charAt(j);
                    if (isValid(s)) {
                        res = (++res) % mod;
                    }
                }
            }
        }
        if (n == 3) {
            for (int i = 0; i < strings[0].length(); i++) {
                for (int j = 0; j < strings[1].length(); j++) {
                    for (int k = 0; k < strings[2].length(); k++) {
                        String s = "" + strings[0].charAt(i) + strings[1].charAt(j) + strings[2].charAt(k);
                        if (isValid(s)) {
                            res++;
                        }
                    }
                }
            }
        }
        System.out.println(res % mod);
    }

    private static boolean isValid(String string) {
        char[] arr = string.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
