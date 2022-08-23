/**
 * Created by Harry Chou at 2019/4/25.
 */
public class Count1 {
    public int NumberOf1(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n & 1);
            n = n >>> 1;
        }
        return sum;
    }
}