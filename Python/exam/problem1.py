class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def insert0(self , head: ListNode) -> ListNode:
        cur=head
        while cur is not None and cur.next is not None:
            new_node=ListNode(0)
            next=cur.next
            cur.next=new_node
            new_node.next=next
            cur=next
        return head
