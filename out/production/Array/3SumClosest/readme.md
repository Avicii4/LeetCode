# 3Sum Closest

链接：[最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/description/)

题意：给定一个包括 *n* 个整数的数组 `nums` 和 一个目标值 `target`。找出 `nums` 中的三个整数，使得它们的和与 `target` 最接近。返回这三个数的和。假定只有一个答案。

分析：参考[3Sum](../3Sum) 这道题。若更加三数之和更加接近 `target` ，则更优。对于小于 `target` 的值，更新要取大，反之取小。