package problems.array.lc34;

/**
 * Created by Harry Chou at 2019/02/06.
 * Description: Given an array of integers nums sorted in ascending order, find
 * the starting and ending position of a given target value.Your algorithm's
 * runtime complexity must be in the order of O(log n).If the target is not
 * found in the array, return [-1, -1].
 */

class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] { -1, -1 };
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int flag1 = 0;
        int flag2 = 0;
        while (left <= right) {
            if (nums[left] == target && flag1 == 0) {
                res[0] = left;
                flag1++;
            }
            if (nums[right] == target && flag2 == 0) {
                res[1] = right;
                flag2++;
            }
            if (flag1 > 0 && flag2 > 0) {
                break;
            }
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                if (flag1 == 0) {
                    left++;
                }
                if (flag2 == 0) {
                    right--;
                }
            }
        }
        return res;
    }
}