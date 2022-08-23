
/**
 * Created by Harry Chou at 2019/6/2.
 */
import java.util.Arrays;

public class MinNumber {
    public String min(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = numbers[i] + "";
        }
        Arrays.sort(strings, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        return sb.toString();
    }
}
