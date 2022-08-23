# Valid Palindrome

链接：[验证回文串](https://leetcode-cn.com/problems/valid-palindrome/description/)

题意：只考虑数字和字母，验证是否是回文串。

分析：从一头一尾开始逐个比较，使用 `Character.isLetterOrDigit()` 方法去掉非数字或字母，用 `Character.toLowerCase()` 方法将所有字符变为小写来比较。

