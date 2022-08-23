
/**
 * Created by Harry Chou at 2019/6/9.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingChar {
    public int findChar(String str) {
        str.trim();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int counter = map.get(str.charAt(i));
                map.put(str.charAt(i), ++counter);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}