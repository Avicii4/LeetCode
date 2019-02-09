# Trapping Rain Water

链接：[接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

题意：给定 *n* 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。如图所示。

![pic](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png)

分析：参考了之前做过的 [盛最多水的容器](../../Math/ContainerWithMostWater) 这一题。用两个指针，每次选择较小的那个向中间靠拢。