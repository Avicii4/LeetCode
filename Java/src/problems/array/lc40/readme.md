# Combination Sum II

链接：[组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/description/)

题意：在一个数组中找出和为目标值的元素，每个元素只能用一次。

分析：本体和上一题 [组合总和](../lc39) 相比，多了一个元素只能用一次的条件。在递归中使 `num` 参数加一即可。考虑排序后，`candidates` 数组中有重复元素，则需要进行剪枝优化。