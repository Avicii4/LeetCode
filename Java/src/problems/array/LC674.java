package problems.array;

public class LC674 {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int curMax = 1, curLength = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                curLength++;
            } else {
                curMax = Math.max(curLength, curMax);
                curLength = 1;
            }
            prev = nums[i];
        }
        curMax = Math.max(curLength, curMax);
        return curMax;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,2,2,3};
        System.out.println(findLengthOfLCIS(arr));

    }
}
