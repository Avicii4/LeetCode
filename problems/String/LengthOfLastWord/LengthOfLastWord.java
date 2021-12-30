/**
 * Created by Avicii4 at 2021/12/30.
 * Given a string s consisting of some words separated by some number
 * of spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        int res = 0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)!=' ') {
                res++;
            } else {
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

}
