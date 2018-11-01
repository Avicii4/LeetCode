# String to Integer (atoi)

链接：[字符串转整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/description/)

题意：将字符串转为整数，需要丢弃任意多的空格字符，提取正负号，与后面尽可能多的连续的数字组合起来。如果转换结果超过了  [−2<sup>31</sup>,  2<sup>31</sup> − 1] ，则返回  INT_MAX 或  INT_MIN。

分析：需要考虑很多的特殊情况，所以要逐位检查，去掉空字符，提取正负符号。检查结果溢出的思想有点类似于 [Reverse Integer](../ReverseInteger/Reverse.java) 这道题。



