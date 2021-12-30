# Length of Last Word

链接：[最后一个单词的长度](https://leetcode-cn.com/problems/length-of-last-word/)

题意：在一个字符串中获取最后一个单词的长度，注意此处字符串中仅含有英文字母和空格。

分析：先trim()一下，然后从末尾开始数，直到遇到第一个空格为止。