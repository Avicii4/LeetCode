# 3Sum

链接：[三数之和](https://leetcode-cn.com/problems/3sum/description/)

题意：在数组中找出三个数，它们的和为 0，找出所有符合条件的三个元素，且不要重复。

分析：首先对数组排序。设置变量 `i` 从头开始向后走，设置变量 `k` 从尾开始向前走，在它们中间找出符合的 `j` 值。在 `i` （或 `k` ）自增（或自减）时，如果 `nums[i]==nums[i+1]` （或 `nums[k]==nums[k-1]`），那么可以跳过此次对 `k` 的寻找，以此提高效率。

更多分析详见我的博客文章：[LeetCode 15：3Sum](https://avicii4.github.io/2019/01/24/leetcode-15/) 。