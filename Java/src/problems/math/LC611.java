package problems.math;

import java.util.Arrays;

public class LC611 {
    // 方法一：先确定前面两个数，然后在后面的序列中找刚好可以组成三角形的值
    public static int triangleNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = i + 1; j <= n - 2; j++) {
                int t = nums[i] + nums[j];
                int left = j + 1, right = n - 1;
                int k = -1;
                while (left <= right) {
                    int mid = left - (left - right) / 2;
                    if (nums[mid] < t) {
                        k = mid;   // 小于t，说明可以组成三角形
                        left = mid + 1;   // 但要继续向右搜寻
                    } else if (nums[mid] >= t) {
                        right = mid - 1;
                    }
                }
                if (k != -1) {
                    res += k - j;
                }
            }
        }
        return res;
    }

    // 方法二
    public static int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while (left < right) {
                // 如果nums[left] + nums[right]都大于nums[i]
                // 那么nums[left+1] + nums[right]、...、nums[right-1] + nums[right]都大于nums[i]
                // 符合条件的三角形就有right - left个
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 4};
        System.out.println(triangleNumber1(arr));
        System.out.println(triangleNumber2(arr));

    }
}
