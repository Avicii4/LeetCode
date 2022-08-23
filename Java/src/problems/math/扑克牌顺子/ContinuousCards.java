/**
 * Created by Harry Chou at 2019/7/1.
 */
public class ContinuousCards {
    public static boolean isContinuous(int[] numbers) {
        int[] arr = new int[14];
        arr[0] = -5;
        int max = -1;
        int min = 14;
        if (numbers.length != 5) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            arr[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (arr[numbers[i]] > 1) {
                return false;
            }
            max = numbers[i] > max ? numbers[i] : max;
            min = numbers[i] < min ? numbers[i] : min;
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        int[] numbers = { 0, 0, 1, 2, 7 };
        System.out.println(isContinuous(numbers));
    }
}
