# Longest Substring Without Repeating Characters

链接：[无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/)

题意：求出不含有重复字符的子串的最大长度。

分析：滑动窗口的思想。可以利用 `HashSet` 的 `add()` 方法判断是否有重复的元素。

