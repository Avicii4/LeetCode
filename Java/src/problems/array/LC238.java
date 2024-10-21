package problems.array;

import java.util.Arrays;

// 给你一个整数数组 nums，返回数组 answer,
// 其中 answer[i] 等于 nums 中除nums[i]之外其余各元素的乘积
// 不许用除法，时间复杂度O(n)
public class LC238 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];  // 前缀积数组
        int[] suffixProduct = new int[n];  // 后缀积数组
        Arrays.fill(prefixProduct, 1);
        Arrays.fill(suffixProduct, 1);
        prefixProduct[0] = nums[0];
        suffixProduct[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i];
        }
        int[] answer = new int[n];
        answer[0] = suffixProduct[1];
        answer[n - 1] = prefixProduct[n - 2];
        for (int i = 1; i < n - 1; i++) {
            answer[i] = prefixProduct[i-1]*suffixProduct[i+1];
        }
        return answer;
    }


    // 参考问题讨论区 https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (B.length != 0) {
            B[0] = 1;
            for (int i = 1; i < B.length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            for (int j = B.length - 1; j > 0; j--) {
                temp *= A[j];
                B[j - 1] *= temp;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        System.out.println(Arrays.toString(productExceptSelf(a)));
    }
}
