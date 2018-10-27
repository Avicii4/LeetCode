/**
 * Created by Harry Chou at 2018/10/27.
 * Description: Given a string, determine if it is a palindrome, considering
 * only alphanumeric characters and ignoring cases.
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] cha = s.toCharArray();
        int i = 0;
        int j = cha.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(cha[i]))
                i++;
            else if (!Character.isLetterOrDigit(cha[j]))
                j--;
            else if (Character.toLowerCase(cha[i]) == Character.toLowerCase(cha[j])) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}