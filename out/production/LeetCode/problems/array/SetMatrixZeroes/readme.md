# Set Matrix Zeroes

链接：[矩阵置零](https://leetcode-cn.com/problems/set-matrix-zeroes/description/)

题意：如果矩阵有一个元素值为0，就将其所在行和列都置为0。

分析：本题要求使用原地算法。可以先找到一个为0的元素，那么它的所在行列都会被置为0，那就可以将这一行和一列分别用来记录该矩阵的某一列和某一行是否需要被置零。最后不要忘记将记录的行和列全部置零。