/**
 * Created by Harry Chou at 2019/6/27.
 */

public class ReverseSentence {
    public String reverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        reverse(chars, blank + 1, chars.length - 1);
        return new String(chars);

    }

    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().reverseSentence("student. a am I"));
    }
}
