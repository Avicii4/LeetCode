# Search2D in Rotated Sorted Array

链接：[[搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)]

题意：在时间复杂度是 *O*(log *n*) 级别下寻找出目标数组元素。

分析：利用二分法的思想。通过找规律，发现若中间的数小于最右边的数，则右半段是有序的；若中间数大于最右边数，则左半段是有序的。再加以二分法思想就可以做出来了。

