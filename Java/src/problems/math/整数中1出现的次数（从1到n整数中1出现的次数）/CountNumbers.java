/**
 * Created by Harry Chou at 2019/6/1.
 */

public class CountNumbers {
    public int countOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            int b = n % i;
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }

    // generalize the method
    public int count(int n, int certainNumber) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            int b = n % i;
            count += (a + 9 - certainNumber) / 10 * i + ((a % 10 == certainNumber) ? b + 1 : 0);
        }
        return count;
    }
}
