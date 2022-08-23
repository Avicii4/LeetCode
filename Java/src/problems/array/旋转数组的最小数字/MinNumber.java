/**
 * Created by Harry Chou at 2019/4/15.
 */
import java.util.ArrayList;

public class MinNumber {
    public int minNumberInRotateArray(int[] array) {
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high--;
            } else {
                high = mid;
            }
        }

        return array[high];
    }
}