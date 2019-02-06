# Find First and Last Position of Element in Sorted Array

链接：[在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

题意：这么长的题目已经讲明了。要求时间复杂度必须是 *O*(log *n*) 级别。

分析：用二分查找的思想来做。设置左、中、右三个变量，如果数组中间值大于目标值，则结果在左子数组中（或者不存在）；如果数组中间值小于目标值，则结果在右子数组中（或者不存在）。以此递归下去。