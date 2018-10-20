/**
 * Created by Harry Chou at 2018/10/16.
 * Description: Write a function that takes a string as input and returns the
 * string reversed.
 */
public class ReverseString {
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}