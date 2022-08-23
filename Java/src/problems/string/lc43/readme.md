# Multiply Strings

链接：[字符串相乘](https://leetcode-cn.com/problems/multiply-strings/)

题意：将两个字符串所表示的数字的乘积计算出来，要求不能直接将字符串转换成数字来做。

分析：模拟以前列竖式计算的方法。主要突破口是第一个数字的第 *i* 位和第二个数字的第 *j* 位会影响乘积的第 *i+j* 和 *i+j+1* 位，注意计算时先要考虑前一位的进位。

