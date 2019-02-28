/**
 * Description: Given an array of size n, find the majority element. The
 * majority element is the element that appears more than ⌊ n/2 ⌋ times.
 */
class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1 || nums.length == 2) {
            return nums[0];
        }
        Arrays.sort(nums);
        int counter = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                counter++;
            } else {
                counter = 1;
            }
            if (counter > nums.length / 2) {
                return nums[i];
            }

        }
        return -1;
    }

    // a better solution
    public int betterMajorityElement(int[] nums) {
        int result = nums[0], count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
                count++;
            } else if (result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}