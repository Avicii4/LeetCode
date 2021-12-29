import java.util.LinkedList;
import java.util.List;

/**
 * Created by Harry Chou at 2019/1/2.
 * Description: Given a string containing digits from 2-9 inclusive, return all
 * possible letter combinations that the number could represent. A mapping of
 * digit to letters (just like on the telephone buttons) is given below. Note
 * that 1 does not map to any letters.
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        String[] dict = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (digits.length() == 0 || digits == null) {
            return result;
        }
        result.add("");
        while (result.peek().length() != digits.length()) {
            String temp = result.pop();
            String value = dict[digits.charAt(temp.length()) - '0'];
            for (char c : value.toCharArray()) {
                result.add(temp + c);
            }
        }
        return result;
    }
}