/**
 * Created by Harry Chou at 2019/5/27.
 */
public class FindGreatestSumOfSubArray {
    public int find_1(int[] array) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            // 考虑数组全为负数的情况
            if (array[i] < 0) {
                result = result > array[i] ? result : array[i];
            }
            sum += array[i];
            result = result > sum ? result : sum;
            sum = sum > 0 ? sum : 0;
        }
        return result;
    }

    public int find_2(int[] array) {
        int sum = array[0];
        int tempSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (tempSum > 0) {
                tempSum += array[i];
            } else {
                tempSum = array[i];
            }
            sum = sum > tempSum ? sum : tempSum;
        }
        return sum;
    }
}
