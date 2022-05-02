# Letter Combinations of a Phone Number

链接：[电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/)

题意：给定一个仅包含数字 `2-9` 的字符串，返回所有它能表示的字母组合。给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

![Phone Number](http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

分析：使用队列。基本思想是，例如，输入的 `digits` 为 `56` ，取出数字 5，将 j、k、l 依次加入队列；取出数字 6，将 m、n、o 加入队列；字母 j、k、l 依次出队与 m、n、o 组合。

 