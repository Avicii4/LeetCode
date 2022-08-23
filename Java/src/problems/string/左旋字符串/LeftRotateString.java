/**
 * Created by Harry Chou at 2019/6/24.
 */

public class LeftRotateString {
    public static String rotate(String str, int n) {
        if (str.length() < n) {
            return "";
        }
        return str.substring(n % str.length()) + str.substring(0, n % str.length());
    }
}
