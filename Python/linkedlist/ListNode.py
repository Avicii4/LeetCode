# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def output(head):
    while head is not None:
        print(head.val, end="")
        head = head.next
        if head is not None:
            print(' → ', end="")
    print()
