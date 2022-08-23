# Linked List Cycle

链接：[环形链表](https://leetcode-cn.com/problems/linked-list-cycle/description/)

题意：判断一个链表里有没有环。

分析：用快慢指针法，只要存在环，那么快指针总会追上慢指针，即 `fast==slow` ，就可以判断是否含环了。