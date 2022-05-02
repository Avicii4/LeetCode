# Intersection of Two Arrays II

链接：[两个数组的交集 II](https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/)

题意：求两个数组的交集。

分析：写两层循环，在找到共同的元素后从由 `nums2` 转化的 `nums2toList` 中剔除。此方法复杂度高，后续更新更好的方法。