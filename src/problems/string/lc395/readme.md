# Longest Substring with At Least K Repeating Characters

链接：[至少有K个重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/)

题意：给出 k，要求给定字符串的子串中，所有字符都至少重复了 k 次。

分析：采用分治思想，首先遍历整个字符串，找到一个词频少于 k 的字符，以这个字符为分界，前后两部分递归查找符合条件的子串。