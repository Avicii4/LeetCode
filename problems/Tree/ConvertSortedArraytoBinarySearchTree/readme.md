# Convert Sorted Array to Binary Search Tree

链接：[将有序数组转换为二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/)

题意：把一个升序排列的有序数组转化为二叉搜索树，每个结点左右子树的高度差不超过1。

分析：二叉搜索树的特点就是结点的值比其左子结点大，比其右子结点小。找到数组的中间一位，将数组左侧的中间一位取出作为新的左子树结点，右边同理。如此递归下去。