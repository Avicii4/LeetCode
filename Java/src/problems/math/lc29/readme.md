# Divide Two Integers

链接：[两数相除](https://leetcode-cn.com/problems/divide-two-integers/)

题意：求两数相除的商，要求不能用乘法、除法和 mod 运算。

分析：利用 Java 的左移运算，每次将除数左移一位，相当于让其乘 2，得到一个不大于被除数的数。然后用被除数去减这个数，并且结果（商）增加 2<sup>k</sup> 。接下来继续迭代，直到得到的数为0。