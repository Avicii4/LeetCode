package problems.string.lc22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry Chou at 2019/01/19.
 * Description: Given n pairs of parentheses, write a function to generate all
 * combinations of well-formed parentheses.
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> strings = new ArrayList<>();
        if (n == 0) {
            return strings;
        }
        dfs(0, 0, "", strings, n);
        return strings;
    }

    private void dfs(int left, int right, String buffer, ArrayList<String> strings, int n) {
        if (left == n && right == n) {
            strings.add(buffer);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, buffer + "(", strings, n);
        }
        if (right < left) {
            dfs(left, right + 1, buffer + ")", strings, n);
        }
    }
}