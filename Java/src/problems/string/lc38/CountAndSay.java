package problems.string.lc38;

/**
 * Created by Harry Chou at 2018/10/30.
 * Description:The count-and-say sequence is the sequence of integers with the
 * first five terms as following:
 *      1.     1
 *      2.     11
 *      3.     21
 *      4.     1211
 *      5.     111221
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String s = countAndSay(n - 1);
        String newStr = new String();
        for (int i = 0; i < s.length();) {
            int count = 1;
            while (i + count < s.length() && s.charAt(i) == s.charAt(i + count))
                count++;
            newStr += String.valueOf(count) + s.charAt(i);
            i += count;
        }
        return newStr;
    }
}