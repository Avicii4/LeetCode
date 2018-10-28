/**
 * Created by Harry Chou at 2018/10/28.
 * Description: Convert a string to an integer.
 */

public class StringToInteger {
    public int myAtoi(String str) {
        str = str.trim();
        int result = 0;
        boolean sign = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+'))
                sign = c == '+' ? true : false;
            else if (c >= '0' && c <= '9') {
                if (result > (Integer.MAX_VALUE - (c - '0')) / 10)
                    return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                result *= 10;
                result += c - '0';
            } else
                return sign ? result : -result;
        }
        return sign ? result : -result;
    }
}
