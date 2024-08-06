package structure.dp;

import java.util.Arrays;
import java.util.Random;


public class RobotWalking {

    /**
     * @param N 总位置
     * @param M 起始位置
     * @param K 总步数
     * @param P 最终目标位置
     */
    public static int slowRobotWalking(int N, int M, int K, int P) {
        return slowWalk(N, M, K, P);
    }

    /**
     * @param N    位置为1 ~ N，固定参数
     * @param cur  当前在cur位置，可变参数
     * @param rest 还剩rest步没有走，可变参数
     * @param P    最终目标位置是P，固定参数
     * @return 当前在cur位置，走完rest步之后，停在P位置的方法数
     */
    private static int slowWalk(int N, int cur, int rest, int P) {
        if (rest == 0) {
            // 如果没有剩余步数，假如当前位置到达了目的地P，就记一种方案数
            return cur == P ? 1 : 0;
        }
        if (cur == 1) {
            // 当前在1位置，那只能往右边走
            return slowWalk(N, cur + 1, rest - 1, P);
        }
        if (cur == N) {
            // 当前在N位置，那只能往左边走
            return slowWalk(N, cur - 1, rest - 1, P);
        }
        // 可以往左边走，还可以往右边走
        return slowWalk(N, cur - 1, rest - 1, P) + slowWalk(N, cur + 1, rest - 1, P);
    }


    /**
     * @param N 总位置
     * @param M 起始位置
     * @param K 总步数
     * @param P 最终目标位置
     */
    public static int dpRobotWalking(int N, int M, int K, int P) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;    // 初始化dp数组
            }
        }
        return dpWalk(N, M, K, P, dp);
    }

    /**
     * dp 缓存所有cur参数和rest参数组合的函数结果
     */
    private static int dpWalk(int N, int cur, int rest, int P, int[][] dp) {
        if (dp[cur][rest] != -1) { // 这个值我之前算过，就无需重复计算了
            return dp[cur][rest];
        }

        if (rest == 0) {
            dp[cur][rest] = (cur == P ? 1 : 0);
            return dp[cur][rest];
        }
        if (cur == 1) {
            dp[cur][rest] = dpWalk(N, 2, rest - 1, P, dp);
            return dp[cur][rest];
        }
        if (cur == N) {
            dp[cur][rest] = dpWalk(N, N - 1, rest - 1, P, dp);
            return dp[cur][rest];
        }
        dp[cur][rest] = dpWalk(N, cur - 1, rest - 1, P, dp) + dpWalk(N, cur + 1, rest - 1, P, dp);
        return dp[cur][rest];
    }


    public static int finalDPRobotWalking(int N, int M, int K, int P) {
        int[][] dp = new int[N + 1][K + 1];
        dp[M][0] = 1;  // 还剩0步，且在P位置上，那就有1种方案
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[j][i] = dp[j + 1][i - 1];
                } else if (j == N) {
                    dp[j][i] = dp[j - 1][i - 1];
                } else {
                    dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
                }
            }
        }
        return dp[P][K];
    }


    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int N = random.nextInt(100) + 2;
            int M = random.nextInt(N) + 1;
            int K = random.nextInt(N) + 1;
            int P = random.nextInt(N) + 1;
            int truth = dpRobotWalking(N, M, K, P);
            int res = finalDPRobotWalking(N, M, K, P);
            if (truth != res) {
                System.out.println("N: " + N + ", M: " + M + ", K: " + K + ", P: " + P);
                System.out.println("Truth: " + truth + ", res: " + res);
                System.exit(-1);
            }
        }
        System.out.println("Success!");
    }

}
