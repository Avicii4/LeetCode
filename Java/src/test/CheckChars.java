package test;

import java.util.HashSet;
import java.util.Set;

public class CheckChars {
    public static boolean checkChars(String a, String b) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            set.add(a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            if (!set.contains(b.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static boolean checkCharsCustom(String a, String b) {
        boolean[] memory = new boolean[64];
        for (int i = 0; i < a.length(); i++) {
            try {
                int idx = getIndex(a.charAt(i));
                memory[idx]=true;
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage());
            }
        }
        for (int i = 0; i < b.length(); i++) {
            int idx = getIndex(b.charAt(i));
            if (!memory[idx]) {
                return false;
            }
        }
        return true;
    }


    private static int getIndex(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A';
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else if (c == '+') {
            return 62;
        } else if (c == '-') {
            return 63;
        } else {
            throw new IllegalArgumentException("Unsupported characters!");
        }
    }


    public static void main(String[] args) {
        String a = "1234567";
        String b = "4436+";
        System.out.println(checkCharsCustom(a, b));
    }
}
