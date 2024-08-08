package problems.array;

import java.util.Arrays;

public class LC283 {
    // 类似插入排序，前端始终维护一个非零序列，后面每当扫到非零数字，就加在这个序列后面
    public static void moveZeroes_1(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            if (cur != 0) {
                int j = i - 1;
                while (j >= 0 && nums[j] == 0) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j + 1] = cur;
            }
        }
    }

    public static void moveZeroes_2(int[] nums) {
        // i是当前非零序列的末尾，j是当前搜索的位置
        int i = 0, j;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                swap(nums, j, i++);
            }
        }
    }

    private static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 4, 12};
        moveZeroes_1(arr);
        moveZeroes_2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
