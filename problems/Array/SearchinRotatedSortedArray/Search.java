/**
 * Created by Harry Chou at 2019/01/27.
 * Description: Suppose an array sorted in ascending order is rotated at some
 * pivot unknown to you beforehand.(i.e., [0,1,2,4,5,6,7] might become
 * [4,5,6,7,0,1,2]).You are given a target value to search. If found in the
 * array return its index, otherwise return -1.
 */

public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                // the right half is sequential
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // the left half is sequential
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}