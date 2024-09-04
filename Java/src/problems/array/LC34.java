package problems.array;

import java.util.Arrays;

public class LC34 {
    public static int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        return new int[]{left, right};
    }

    // leftBias为true，表示算法会向左缩小范围，否则是向右缩小范围
    private static int binarySearch(int[] nums, int target, boolean leftBias) {
        int l = 0, r = nums.length - 1;
        int tmp = -1;
        while (l <= r) {
            int mid = l - (l - r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                // 虽然找到了目标值，但并不一定是最左（最右）的边界，
                // 还要继续缩小搜索范围，继续二分
                tmp = mid;
                if (leftBias) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int[] res = searchRange(arr, 71);
        System.out.println(Arrays.toString(res));
    }
}
