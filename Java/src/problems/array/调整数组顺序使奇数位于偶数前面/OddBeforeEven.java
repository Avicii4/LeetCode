/**
 * Created by Harry Chou at 2019/4/27.
 */
public class OddBeforeEven {
    public void reOrderArray_1(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] % 2 == 0 && array[i + 1] % 2 != 0) {
                    array[i] = array[i] ^ array[i + 1];
                    array[i + 1] = array[i] ^ array[i + 1];
                    array[i] = array[i] ^ array[i + 1];
                }
            }
        }
    }

    public void reOrderArray_2(int[] array) {
        int[] result = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                result[j] = array[i];
                j++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result[j] = array[i];
                j++;
            }
        }
        System.arraycopy(result, 0, array, 0, array.length);
    }
}