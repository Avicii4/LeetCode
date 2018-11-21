/**
 * Description: Determine whether an integer is a palindrome. An integer is a
 * palindrome when it reads the same backward as forward.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x);
        String reversedStr = new StringBuffer(str).reverse().toString();
        if (str.equals(reversedStr)) {
            return true;
        } else {
            return false;
        }
    }
}