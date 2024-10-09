package problems.dp;

public class LC55 {
    // 此题只有贪心法可以过所有用例，记忆化DFS也超时
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;  // 倒着
        // 倒着看，如果我们能从前面的x位置到达后面的goal位置，
        // 那么接下来就看能不能从更前面的位置到达x位置
        // 不断倒推，直到走到0号位置
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }


    public static void main(String[] args) {
        int[] arr = {2, 0, 0};
        System.out.println(canJump(arr));
    }
}
