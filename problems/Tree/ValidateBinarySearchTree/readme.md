# Validate Binary Search Tree

链接：[验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree/description/)

题意：判断是否是有效的二叉搜索树。

分析：思路是利用二叉搜索树的中序遍历结果为有序序列的特性。中序遍历的顺序是：
1. 若左结点不为空，中序遍历左结点。
2. 输出父节点。
3. 若右结点不为空，中序遍历右结点。

再建立一个 ArrayList 用来存入每次输出的结点值，最后一个个判断元素之间大小关系是否正确。
