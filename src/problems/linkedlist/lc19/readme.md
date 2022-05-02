# Remove Nth Node From End of List

链接：[删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/)

题意：删除链表的倒数第 *n* 个节点，并且返回链表的头结点。

分析：使用双指针解法。第一个指针先走到第 *n* 个结点处，此时第二个指针与第一个一同走，当第一个指针走到末尾，第二个指针就到了倒数第 *n* 个结点处。注意考虑删除头结点的情况。