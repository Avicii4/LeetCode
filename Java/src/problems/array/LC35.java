package problems.array;

/**
 * Created by Harry Chou at 2019/01/31.
 * Description: Given a sorted array and a target value, return the index if the
 * target is found. If not, return the index where it would be if it were
 * inserted in order.
 */
public class LC35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        System.out.println(searchInsert(a, 4));
    }

}