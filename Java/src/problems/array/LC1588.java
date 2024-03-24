package problems.array;

import java.util.Arrays;

public class LC1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] preSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            preSum[i + 1] += arr[i] + preSum[i];
        }
        int step = 1;
        int res = 0;
        while (step <= arr.length) {
            for (int i = 0; i <= arr.length - step; i++) {
                res += preSum[i + step] - preSum[i];
            }
            step+=2;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 2, 5, 3};
        System.out.println(new LC1588().sumOddLengthSubarrays(a));

    }

}
