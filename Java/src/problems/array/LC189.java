package problems.array;

import java.util.Arrays;

public class LC189 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        k = n-k;
        int[] help = new int[n];
        System.arraycopy(nums, k, help, 0, n - k);
        System.arraycopy(nums, 0, help, n - k, k);
        System.arraycopy(help, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        rotate(a,3);
        System.out.println(Arrays.toString(a));
    }
}

