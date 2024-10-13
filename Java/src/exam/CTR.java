package exam;

import java.util.Scanner;

public class CTR {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int subarrGCD(int[] arr, int start, int end) {
        int res = arr[start];
        for (int i = start + 1; i <= end; i++) {
            res = gcd(res, arr[i]);
        }
        return res;
    }

    public static void dfs(int[] arr, int m, int start, int curGCDSum, int[] res) {
        if (m == 1) {
            int lastgcd = subarrGCD(arr, start, arr.length - 1);
            res[0] = Math.max(res[0], lastgcd + curGCDSum);
            return;
        }
        for (int i = start; i <= arr.length - m; i++) {
            int curgcd = subarrGCD(arr, start, i);
            dfs(arr, m - 1, i + 1, curGCDSum + curgcd, res);
        }
    }

    public static int maxGCD(int[] arr, int m) {
        int[] res = new int[]{-1};
        dfs(arr, m, 0, 0, res);
        return res[0];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        int[] nums = new int[n];

        String s = in.nextLine().strip();
        String[] ns = s.split(" ");

        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.valueOf(ns[i]);
        }
        System.out.println(maxGCD(nums, m));
    }
}
