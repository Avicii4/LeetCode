/**
 * Created by Harry Chou at 2019/7/4.
 */
public class Sum {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean base = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
