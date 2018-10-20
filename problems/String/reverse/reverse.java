/**
 * Created by Harry Chou at 2018/10/17.
 * Description: Given a 32-bit signed integer, reverse digits of an integer. And
 * returns 0 when the reversed integer overflows.
 */
public class Reverse {
    public int reverseStr(int x) {
        int result = 0;
        while (x != 0) {
            int temp = result * 10 + x % 10;
            if (temp / 10 != result) {
                return 0;
            }
            result = temp;
            x /= 10;
        }
        return result;
    }
}