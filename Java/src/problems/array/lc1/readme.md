# Two Sum

链接：[两数之和](https://leetcode-cn.com/problems/two-sum/description/)

题意：找出数组中和为目标值的两元素的下标。

分析：双层循环，注意第二层的循环不用从头开始。

更新：使用 HashMap 一次遍历，在插入该数前先去 HashMap 中查找有没有另外一个数，若有就可以直接返回了；若没有再插入，继续迭代。

