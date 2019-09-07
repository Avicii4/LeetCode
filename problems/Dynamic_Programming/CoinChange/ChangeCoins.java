/**
 * Created by Harry Chou at 2019/9/7.
 * Description: You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class ChangeCoins {
	public static int coinChange(int[] coins, int amount) {
		if (amount == 0) {
			return 0;
		}
		// dp[i]表示到金额i时用到的最少数量
		int[] dp = new int[amount + 1];
		// 金额为0已经考虑过了
		for (int i = 1; i <= amount; i++) {
			dp[i] = 99999;
			for (int coin : coins) {
				// 当前金额减去某个面额时用到的数量
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
				}
			}
		}
		return dp[amount] == 99999 ? -1 : dp[amount];
	}
}
