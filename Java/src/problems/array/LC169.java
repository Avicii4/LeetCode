package problems.array;

public class LC169 {
    // 使用的其实是 Boyer-Moore 投票算法
    public static int majorityElement(int[] nums) {
        int curNumber = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                curNumber = num;
                count++;
            } else if (curNumber == num) {
                count++;
            } else {
                count--;
            }
        }
        return curNumber;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 1, 0, 1, 2, 1, 1};
        System.out.println(majorityElement(arr));
    }
}
