package problems.dp;

public class LC45 {
    // 贪心法
    public static int jump(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int res = 0;
        // 从0位置开始，我会有一个可达区间A，从A区间又有下一个可达区间B……
        // 用left,right标记每一个区间边界，
        // 遍历区间，看我能跳到最远的地方是哪，直到到达n-1位置
        while (right < n - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            res++;
            left = right + 1;
            right = farthest;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(jump(arr));
    }
}
