package problems.array;

// 未排序，找出数组没有出现的最小的正整数
public class LC41 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 第一趟，把负数修改为0
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        // 第二趟，将对应位置上的数改成负数
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (idx >= 0 && idx < n) {
                if (nums[idx] > 0) {
                    nums[idx] *= -1;
                } else if (nums[idx] == 0) {
                    nums[idx] = -n - 1;
                }
            }
        }

        // 第三趟，检查哪个位置的数是非负的
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        System.out.println(firstMissingPositive(arr));
    }
}
