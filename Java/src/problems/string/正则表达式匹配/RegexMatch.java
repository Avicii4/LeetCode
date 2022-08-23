/**
 * Created by Harry Chou at 2019/7/16.
 */
public class RegexMatch {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return compare(str, strIndex, pattern, patternIndex);
    }

    private boolean compare(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')) {
                return compare(str, strIndex, pattern, patternIndex + 2) || compare(str, strIndex + 1, pattern, patternIndex);
            } else {
                return compare(str, strIndex, pattern, patternIndex + 2);
            }
        }
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (strIndex != str.length && pattern[patternIndex] == '.')) {
            return compare(str, strIndex + 1, pattern, patternIndex + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c'};
        char[] pattern = {'a', 'b', 'c', 'a', '*', 'b', '*'};

        System.out.println(new RegexMatch().match(str, pattern));
    }
}
