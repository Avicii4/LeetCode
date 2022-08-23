/**
 * Created by Harry Chou at 2019/4/18.
 */
public class GetFibonacci {
    public int getFibonacci_1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int getFibonacci_2(int n) {
        int f = 0;
        int g = 1;
        while (n > 0) {
            g += f;
            f = g - f;
            n--;
        }
        return f;
    }
}