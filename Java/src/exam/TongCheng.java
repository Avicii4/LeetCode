package exam;

import java.util.Arrays;

public class TongCheng {

    public static int giftExch(int[] points, int[] counts, int X) {
        long[] dp = new long[X + 1];  // 恰好花费i个积分最少买的商品数
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < points.length; i++) {
            int p = points[i];
            int cnt = counts[i];
            for (int curMoney = X; curMoney >= p; curMoney--) {
                for (int c = 1; c <= cnt; c++) {
                    int cost = c * p;
                    if (curMoney >= cost) {
                        dp[curMoney] = Math.min(dp[curMoney], dp[curMoney - cost] + c);
                    }
                }

            }

        }
        return dp[X] == Integer.MAX_VALUE ? -1 : (int) dp[X];
    }

    public static void main(String[] args) {
        int[] p = {2, 3, 7, 11, 13};
        int[] c = {1, 2, 3, 4, 5};
        int X = 30;
        System.out.println(giftExch(p, c, X));
    }


}
