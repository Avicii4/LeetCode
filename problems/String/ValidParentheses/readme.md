# Valid Parentheses

链接：[有效的括号](https://leetcode-cn.com/problems/valid-parentheses/description/)

题意：给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串，判断字符串是否有效。有效字符串需满足：
1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。
3. 注意空字符串可被认为是有效字符串。

分析：使用 `Stack` 结构，当栈顶字符与下一个字符匹配时，将其推出栈。最后栈为空即为符合条件。