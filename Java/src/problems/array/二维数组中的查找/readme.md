# 二维数组中的查找

**题目描述：**

在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

**分析：**

从二维数组的左下角开始查找，若遇到的数大于目标值，则向上再找；否则向右查找。
