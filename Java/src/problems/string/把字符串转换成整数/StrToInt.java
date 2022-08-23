/**
 * Created by Harry Chou at 2019/7/6.
 */
public class StrToInt {
    public static int transfer(String str) {
        str = str.trim();
        if ("-2147483648".equals(str)) {
            return Integer.MIN_VALUE;
        }
        int result = 0;
        int sign = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) {
                sign = c == '+' ? 1 : -1;
            } else if (c >= '0' && c <= '9') {
                if (result > (Integer.MAX_VALUE - (c - '0')) / 10) {
                    return 0;
                }
                result = result * 10 + c - '0';
            } else {
                return 0;
            }
        }
        return sign * result;
    }

    public static void main(String[] args) {
        System.out.println(transfer("-2147483648"));
    }
}
