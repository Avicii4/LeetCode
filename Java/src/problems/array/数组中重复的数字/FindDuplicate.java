/**
 * Created by Harry Chou at 2019/7/7.
 */
public class FindDuplicate {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            int val = numbers[i] % length;
            if (numbers[val] >= length) {
                duplication[0] = val;
                return true;
            }
            numbers[val] += length;
        }
        return false;
    }
}
