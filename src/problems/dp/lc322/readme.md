# Coin Change

链接：[零钱兑换](https://leetcode-cn.com/problems/coin-change/)

题意：给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

分析：动态规划。使用一个数组记录到某一金额时的最小硬币数目，根据状态转移方程`dp[i] = Math.min(dp[i - coin] + 1, dp[i])` 实现。