package problems.array;

import java.util.Arrays;

public class LC75 {
    // 基本就是快排的一次partition过程
    public static void sortColors(int[] nums) {
        int less = -1, more = nums.length;
        int cur = 0;
        while (cur < more) {
            if (nums[cur] == 0) {
                swap(nums, cur++, ++less);
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, --more);
            }
        }
    }


    private static void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,1,1};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
