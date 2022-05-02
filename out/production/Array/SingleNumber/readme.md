# Single Number

链接：[只出现一次的数字](https://leetcode-cn.com/problems/single-number/description/)

题意：找出数组只出现一次的数字

分析：用 `Arrays.sort()` 排序后进行两两比较，该方法没有使用额外空间。