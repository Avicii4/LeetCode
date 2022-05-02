# Merge Sorted Array

链接：[合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/description/)

题意：给定两个有序整数数组 *nums1* 和 *nums2*，将 *nums2* 合并到 *nums1* 中*，*使得 *num1* 成为一个有序数组。 *nums1* 有足够的空间来保存 *nums2* 中的元素。

分析：每次比较两个数组的最后一个元素，较大者放在 *nums1* 的最后。若 *m>n* ，那么直接得到结果；如果 *m<n* ，那么把 *nums2* 剩余的元素全部填入 *nums1* 即可。