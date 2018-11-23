# Integer to Roman

链接：[整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman/description/)

题意：给出的信息与另一题（[罗马数字转整数](../RomantoInteger)）一样。要求给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

分析：完整的罗马数字与阿拉伯数字对照如下

| 字符 | 数值 |
| :--: | :--: |
|  I   |  1   |
|  IV  |  4   |
|  V   |  5   |
|  IX  |  9   |
|  X   |  10  |
|  XL  |  40  |
|  L   |  50  |
|  XC  |  90  |
|  C   | 100  |
|  CD  | 400  |
|  D   | 500  |
|  CM  | 900  |
|  M   | 1000 |

选择与给定的 *num* 最接近但不超过的数值，就可以得出结果。