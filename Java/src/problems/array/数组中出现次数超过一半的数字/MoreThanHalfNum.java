
/**
 * Created by Harry Chou at 2019/5/25.
 */
import java.util.Arrays;

public class MoreThanHalfNum {
    public int findNum(int[] array) {
        Arrays.sort(array);
        int len = array.length;
        int mid = len / 2;
        int counter = 1;
        for (int i = mid - 1; i >= 0; i--) {
            if (array[i] == array[mid]) {
                counter++;
            } else {
                break;
            }
        }
        for (int i = mid + 1; i < len; i++) {
            if (array[i] == array[mid]) {
                counter++;
            } else {
                break;
            }
        }
        return counter > len / 2 ? array[mid] : 0;
    }
}
