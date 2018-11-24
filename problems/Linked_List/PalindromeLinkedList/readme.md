# Palindrome Linked List

链接：[回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/description/)

题意：判断一个链表是否为回文链表。

分析：先用快慢指针，快指针每次跳两下，慢指针每次跳一下，这样快指针到底时，慢指针正好到链表的一半。之后反转后半部分链表，与前面的对比判断。