package problems.array;

// 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。
// 返回让数组所有元素相等的最小操作次数。
public class LC453 {
    public static int minMoves(int[] nums) {
        // 脑筋急转弯，对n-1个元素+1，等价于对一个数-1
        // 所以就是求数组所有元素 - 数组最小值 之和
        int sum = 0;
        int min = nums[0];
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - nums.length * min;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        System.out.println(minMoves(a));
    }
}
