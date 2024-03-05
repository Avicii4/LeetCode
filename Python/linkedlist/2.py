from ListNode import ListNode, output
from typing import Optional
from random import randint


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        p, q = l1, l2
        head = ListNode(-1)
        pre = head
        carry = 0
        while p or q:
            m = p.val if p else 0
            n = q.val if q else 0
            sum = m + n + carry
            if sum < 10:
                carry = 0
                new_node = ListNode(sum)
            else:
                carry = 1
                new_node = ListNode(sum - 10)
            pre.next = new_node
            pre = new_node
            if p:
                p = p.next
            if q:
                q = q.next
        if carry > 0:  # 两个数都结束了，但最后还要进位1
            pre.next = ListNode(carry)
        return head.next


if __name__ == '__main__':
    for _ in range(1000):
        len_l1 = randint(1, 10)
        len_l2 = randint(1, 10)
        l1, l2 = ListNode(-1), ListNode(-1)
        pre1, pre2 = l1, l2
        string1, string2 = '', ''
        for i in range(len_l1):
            n1 = ListNode(randint(1, 9))
            pre1.next = n1
            pre1 = n1
            string1 += str(n1.val)
        for i in range(len_l2):
            n2 = ListNode(randint(1, 9))
            pre2.next = n2
            pre2 = n2
            string2 += str(n2.val)

        gt = str(int(string1[::-1]) + int(string2[::-1]))[::-1]
        h = Solution().addTwoNumbers(l1.next, l2.next)
        pred = ''
        while h:
            pred += str(h.val)
            h = h.next
        if pred != gt:
            output(l1.next)
            output(l2.next)
            print(gt)
            print(pred)
            exit('Fail!')
    else:
        print('Success!')
