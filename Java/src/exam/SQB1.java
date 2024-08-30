package exam;

import java.util.Scanner;

public class SQB1 {
    public static long calc(long n, long d) {
        long sum = 0;
        if (n < d) {
            return 0;
        }
        long i = d;

        while (i <= n) {
            if (i % d == 0) {// 整除
                sum += (i / d) * d;
                i += d;
            }
        }
        if (i > n) {
            sum = sum - ((i - 1) / d * (i - n - 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long n = scanner.nextInt();
            long d = scanner.nextInt();
            System.out.println(calc(n, d));
        }
    }
}
