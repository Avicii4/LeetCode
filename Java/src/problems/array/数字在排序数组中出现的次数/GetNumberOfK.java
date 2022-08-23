/**
 * Created by Harry Chou at 2019/6/12.
 */
public class GetNumberOfK {
    public int getNumber(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == k) {
                int counter = 0;
                for (int i = mid; i < array.length; i++) {
                    if (array[mid] == array[i]) {
                        counter++;
                    } else {
                        break;
                    }
                }
                for (int i = mid - 1; i >= 0; i--) {
                    if (array[mid] == array[i]) {
                        counter++;
                    } else {
                        break;
                    }
                }
                return counter;
            } else if (array[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return 0;
    }
}
