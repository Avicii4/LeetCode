package problems.array;

import java.util.Arrays;

public class LC167 {
    public static int[] twoSum(int[] numbers, int target) {
        int p = 0, q = numbers.length - 1;
        while (p < q) {
            int cur = numbers[p] + numbers[q];
            if (cur == target) {
                return new int[]{p + 1, q + 1};
            } else if (cur < target) {
                p++;
            } else {
                q--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 9, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 20)));
    }
}
