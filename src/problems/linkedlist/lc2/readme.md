# Add Two Numbers

链接：[两数相加](https://leetcode-cn.com/problems/add-two-numbers/description/)

题意：两个非空链表逆序存储两个整数，返回一个链表来求两数之和。

分析：逐位相加数字，考虑进位和该位是否为空的问题。注意，假如求和的最后还可能有一位进位（比如 `99+1` 的情况），应该再加一个值为 `1` 的结点。