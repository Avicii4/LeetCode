package test;

import java.util.Arrays;

public class XORTest {
    public static int findNumber(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }

    public static int[] findTwoNumber(int[] arr) {
        int xorResult = 0;
        for (int j : arr) {
            xorResult ^= j;
        }
        int mostRightOne = xorResult & (~xorResult + 1);
        int oneAns = 0;
        for (int num : arr) {
            if ((num & mostRightOne) == 1) {
                oneAns ^= num;
            }
        }
        return new int[]{oneAns, xorResult ^ oneAns};
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 4, 3, 3, 2, 2, 2, 6, 7, 0, 0};
        System.out.println(findNumber(a));
        System.out.println(Arrays.toString(findTwoNumber(a)));
    }
}
