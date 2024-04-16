package exam;

import java.util.Scanner;

/**
 * 考虑将连续相邻的若干个（1个或多个）元素分组并求和，
 * 得到一个新的单调不减序列，要求满足条件的最大分组数。
 */
public class SplitArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int maxGroups = 1;
        int curSum = 0;
        int preSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (curSum < preSum) {
                curSum += nums[i];
            } else {
                maxGroups++;
                preSum = curSum;
                curSum = nums[i];
            }
        }
        if (curSum >= preSum) {
            maxGroups++;
        }
        System.out.println(maxGroups);
    }
}
