/**
 * Created by Harry Chou at 2018/12/11.
 * Description: Given a string containing just the characters '(', ')', '{',
 * '}', '[' and ']', determine if the input string is valid.
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (isMatch(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public boolean isMatch(char c1, char c2) {
        if ((c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}')) {
            return true;
        } else {
            return false;
        }
    }
}