
/**
 * Created by Harry Chou at 2019/5/25.
 */
import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
    public ArrayList<String> findAllPermutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() > 0 || str != null) {
            process(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    private static void process(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            String val = String.valueOf(chars);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                process(chars, i + 1, list);
                swap(chars, i, j);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
