def output(head):
    while head is not None:
        print(head.value, end="")
        head = head.next
        if head is not None:
            print('->', end="")
    print()


class ListNode:
    def __init__(self, value):
        self.value = value
        self.next = None


def reverse_linked_list(head):
    pre, next = None, None  # 需要时刻记录前一个和后一个结点
    while head is not None:
        next = head.next
        head.next = pre
        pre = head
        head = next
    return pre


def delete_node_with_value(head, target):
    # 头部可能需要删，故先找到第一个非目标值的结点
    while head is not None:
        if head.value != target:
            break
        head = head.next
    pre, cur = head, head
    while cur is not None:
        if cur.value == target:
            pre.next = cur.next
        else:
            pre = cur
        cur = cur.next
    return head


if __name__ == '__main__':
    node_arr=[ListNode(x) for x in range(10)]
    node_arr[7].value=0
    # Connecting nodes
    for i in range(9):
        node_arr[i].next=node_arr[i+1]
    output(node_arr[0])
    # output(reverse_linked_list(node_arr[0]))
    output(delete_node_with_value(node_arr[0],0))
