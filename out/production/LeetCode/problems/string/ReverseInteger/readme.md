# Reverse Integer

链接：[反转整数](https://leetcode-cn.com/problems/reverse-integer/description/)

题意：反转一个32位带符号整数。如果超出 `int` 类型的范围，返回 `0` 。

分析：每次取出末尾一位的数字放在最高位，并检查是否溢出。