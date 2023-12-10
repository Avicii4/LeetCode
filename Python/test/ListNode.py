def output(head):
    while head is not None:
        print(head.value, end="")
        head = head.next


class ListNode:
    def __init__(self, value):
        self.value = value
        self.next = None


def reverse_linked_list(head):
    pre, next = ListNode(None), ListNode(None)
    while head is not None:
        next=head.next
        head.next=pre
        pre=head
        head=next
    return pre


if __name__ == '__main__':
    node1 = ListNode(1)
    node2 = ListNode(2)
    node3 = ListNode(3)
    # Connecting nodes
    node1.next = node2
    node2.next = node3
    output(node1)
    print()
    # reverse_linked_list(node1)
    output(reverse_linked_list(node1))
