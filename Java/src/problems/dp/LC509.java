package problems.dp;

/**
 * Created by Harry Chou at 2019/4/18.
 */
public class LC509 {
    public static int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n) {
        int f = 0;
        int g = 1;
        while (n > 0) {
            g += f;
            f = g - f;
            n--;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(fib1(12));
        System.out.println(fib2(12));
    }
}