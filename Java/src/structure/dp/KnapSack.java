package structure.dp;

public class KnapSack {

    // 基础暴力方法
    public static int knapSack(int[] weights, int[] values, int capacity) {
        return process(weights, values, 0, capacity);
    }

    // 剩下rest的容量，返回还可以得到多少的价值
    private static int process(int[] weights, int[] values, int index, int rest) {
        if (rest <= 0) {
            return 0;
        }
        if (index == weights.length) {
            return 0;
        }
        // 不选当前的物品
        int p1 = process(weights, values, index + 1, rest);
        int p2 = Integer.MIN_VALUE;
        if (rest > weights[index]) {
            // 选择当前的物品
            p2 = values[index] + process(weights, values, index + 1, rest - weights[index]);
        }
        return Math.max(p1, p2);
    }


    // 动态规划
    public static int dpKnapSack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        // 本身dp数组的n行应该全部填0，因为上面index == weights.length
        // 但Java数组初始化本来就都是0，所以不用特意赋值

        for (int index = n - 1; index >= 0; index--) {  // 从底下的行开始向上填dp数组
            for (int rest = 1; rest <= capacity; rest++) { // 从左向右填写数组
                int p1 = dp[index + 1][rest]; // 不选当前的物品
                int p2 = Integer.MIN_VALUE;
                if (rest > weights[index]) {  // 选择当前的物品
                    p2 = values[index] + dp[index][rest - weights[index]];
                }
                dp[index][rest] = Math.max(p1, p2);  // 容量为rest，可选物品的下标从index开始
            }
        }
        return dp[0][capacity];
    }
}
