/**
 * Created by Harry Chou at 2019/02/10.
 * Description: Given two binary strings, return their sum (also a binary
 * string).The input strings are both non-empty and contains only characters 1
 * or 0.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        int firstSize = a.length() - 1;
        int secondSize = b.length() - 1;
        int flag = 0;
        while (Math.max(firstSize, secondSize) >= 0) {
            int aIndex = firstSize < 0 ? 0 : a.charAt(firstSize) - '0';
            int bIndex = secondSize < 0 ? 0 : b.charAt(secondSize) - '0';
            int temp = aIndex + bIndex + flag;
            if (temp == 0) {
                res.append("0");
                flag = 0;
            } else if (temp == 1) {
                res.append("1");
                flag = 0;
            } else if (temp == 2) {
                res.append("0");
                flag = 1;
            } else {
                res.append("1");
                flag = 1;
            }
            firstSize--;
            secondSize--;
        }
        if (flag == 1) {
            res.append("1");
        }
        return res.reverse().toString();
    }
}