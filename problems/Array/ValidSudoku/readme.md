# Valid Sudoku

链接：[有效的数独](https://leetcode-cn.com/problems/valid-sudoku/description/)

题意：如果数独合法有效，那么在每行、每列和每个九宫格都不能出现重复的数字。

分析：使用 `HashSet` 的 `add()` 方法，如果试图插入一个已存在的元素，则函数会返回 `false` ，以此特性进行判断。注意分析九宫格情况下的行列标规律。