# Symmetric Tree

链接：[对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/description/)

题意：判断一个二叉树是否对称。

分析：二叉树对称，需要一个结点的左（右）子树和对应结点的右（左）子树相等，并且它们各自的子节点也要符合这个规则。自然想到了使用递归解决。