/**
 * Created by Harry Chou at 2019/7/17.
 */
public class NumbericString {
    public boolean isNumeric(char[] str) {
        int len = str.length;
        boolean sign = false;
        boolean point = false;
        boolean hasE = false;
        for (int i = 0; i < len; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                sign = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (i == len - 1 || hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '.') {
                if (hasE || point) {
                    return false;
                }
                point = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
