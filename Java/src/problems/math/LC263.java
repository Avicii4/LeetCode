package problems.math;

public class LC263 {
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(60));
        System.out.println(isUgly(77));
        System.out.println(isUgly(0));
    }
}
