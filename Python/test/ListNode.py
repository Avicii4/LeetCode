def output(head):
    while head is not None:
        print(head.value, end="")
        head = head.next
        if head is not None:
            print(' → ', end="")
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
    return pre  # 注意最后返回pre,此时head为空,pre是原来的末尾,如今是头


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


def mid_node_1(head: ListNode):
    """
    输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    """
    if head is None or head.next is None or head.next.next is None:
        return head
    # 此时链表最少3个节点
    slow = head.next
    fast = head.next.next
    # 自己想一下，假如链表有3、4、5、6……个节点的情况
    while fast.next is not None and fast.next.next is not None:
        slow = slow.next
        fast = fast.next.next
    return slow


def mid_node_2(head: ListNode):
    """
    输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    """
    if head is None or head.next is None:
        return head
    if head.next.next is None:
        return head.next
    slow = head.next
    fast = head.next
    while fast.next is not None and fast.next.next is not None:
        slow = slow.next
        fast = fast.next.next
    return slow


def mid_node_3(head: ListNode):
    """
    输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
    """
    if head is None or head.next is None or head.next.next is None:
        return None
    slow = head
    fast = head.next.next
    while fast.next is not None and fast.next.next is not None:
        slow = slow.next
        fast = fast.next.next
    return slow


def mid_node_4(head: ListNode):
    """
    输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个(即上中点)
    """
    if head is None or head.next is None:
        return None
    if head.next.next is None:
        return head

    slow = head
    fast = head.next
    while fast.next is not None and fast.next.next is not None:
        slow = slow.next
        fast = fast.next.next
    return slow


def is_palindrome(head: ListNode) -> bool:
    if head is None or head.next is None:
        return True
    stack = list()
    p = head
    while head is not None:
        stack.append(head)
        head = head.next
    while len(stack) > 0:
        q = stack.pop()
        if p.value != q.value:
            return False
        p = p.next
    return True


def is_palindrome_2(head: ListNode) -> bool:
    if head is None or head.next is None:
        return True

    slow, fast = head, head
    while fast.next is not None and fast.next.next is not None:
        slow = slow.next
        fast = fast.next.next
    stack = list()
    slow = slow.next
    while slow is not None:
        stack.append(slow)
        slow = slow.next
    while len(stack) > 0:
        if head.value != stack.pop().value:
            return False
        head = head.next
    return True


def is_palindrome_3(head: ListNode) -> bool:
    if not head or not head.next:
        return True
    # 寻找中点（偶数个节点的话就是找上中点）
    slow, fast = head, head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next

    # 将后半部分反转
    p = slow.next
    pre, next = None, None
    while p:
        next = p.next
        p.next = pre
        pre = p
        p = next
    slow.next = None

    # 前后比较
    res = True
    second_half = pre
    while head and pre:
        if head.value != pre.value:
            res = False
        head = head.next
        pre = pre.next

    # 复原链表
    pre, next = None, None
    while second_half:
        next = second_half.next
        second_half.next = pre
        pre = second_half
        second_half = next
    return res


def list_partition(head: ListNode, pviot: int):
    sh, st = None, None  # small head, small tail
    eh, et = None, None  # equal head, equal tail
    bh, bt = None, None  # big head, big tail

    next = None
    while head:
        if head.value < pviot:
            if sh is None:
                sh, st = head, head
            else:
                st.next = head
                st = head
        elif head.value == pviot:
            if eh is None:
                eh, et = head, head
            else:
                et.next = head
                et = head
        else:
            if bh is None:
                bh, bt = head, head
            else:
                bt.next = head
                bt = head
        head = next

    if st:  # 如果有小于区域
        st.next = eh  # 小于区域的尾连等于区域的头
        if et is None:
            et = st  # 如果等于区域为空，那么就由小于区域的尾去连接大于区域的头
    if et:  # 如果小于、等于区域不是全为空的，那就去连接大于区域的头
        et.next = bh

    return sh if sh else eh if eh else bh  # 非空时才返回


class NewNode:
    def __init__(self, value):
        self.value = value
        self.next = None
        self.rand = None


def copy_list(head: NewNode):
    # 用哈希表辅助
    node_map = dict()
    cur = head
    while cur:  # 为每个节点创建一个新节点
        node_map[cur] = NewNode(cur.value)
        cur = cur.next
    cur = head
    while cur:
        node_map[cur].next = node_map[cur.next]
        node_map[cur].rand = node_map[cur.rand]
    return node_map[head]


def copy_list_2(head: NewNode):
    if head is None:
        return None
    cur, next = head, None
    while cur:  # 1->2    1->1'->2->2'
        next = cur.next
        cur.next = NewNode(cur.value)
        cur.next.next = next
        cur = next
    cur = head
    while cur:
        next = cur.next.next
        cur_copy = cur.next
        cur_copy.rand = cur.rand.next if cur.rand else None
        cur = next

    res = head.next  # 新链表的头部
    cur = head
    while cur:
        next = cur.next.next
        cur_copy = cur.next
        cur.next = next
        cur_copy.next = next.next if next else None
        cur = next
    return res


# 两个链表相交
def get_intersect_node(head1: ListNode, head2: ListNode):
    if head1 is None or head2 is None:
        return None
    loop1, loop2 = get_loop_node(head1), get_loop_node(head2)
    if loop1 is None and loop2 is None:
        return no_loop(head1, head2)
    if loop1 and loop2:
        return both_loop(head1, loop1, head2, loop2)
    return None


def no_loop(head1, head2):
    cur1, cur2 = head1, head2
    n = 0
    while cur1:
        n += 1
        cur1 = cur1.next
    while cur2:
        n -= 1
        cur2 = cur2.next
    if cur1 != cur2:  # 两者尾巴不同，肯定不相交
        return None
    # 让cur1在较长链表上遍历，cur2在较短链表上遍历，
    if n >= 0:
        cur1, cur2 = head1, head2
    else:
        cur1, cur2 = head2, head1

    n = abs(n)
    while n > 0:
        n -= 1
        cur1 = cur1.next
    while cur1 != cur2:
        cur1, cur2 = cur1.next, cur2.next
    return cur1


def both_loop(head1, loop1, head2, loop2):
    if loop1 == loop2:
        # 入环位置一样时，处理方法和 no_loop 一样
        cur1, cur2 = head1, head2
        n = 0
        while cur1 != loop1:
            n += 1
            cur1 = cur1.next
        while cur2 != loop2:
            n -= 1
            cur2 = cur2.next
        if n >= 0:
            cur1, cur2 = head1, head2
        else:
            cur1, cur2 = head2, head1
        n = abs(n)
        while n > 0:
            n -= 1
            cur1 = cur1.next
        while cur1 != cur2:
            cur1, cur2 = cur1.next, cur2.next
        return cur1
    else:
        # 如果loop1和loop2不同，
        # 那么从loop1开始在环里遍历，如果能遇到loop2，说明两链表相交
        cur1 = loop1.next
        while cur1 != loop1:
            if cur1 == loop2:
                return loop1  # 返回谁都行，都算两链表的交点
            cur1 = cur1.next
        return None


def get_loop_node(head):
    """
    找到一个有环单链表入环的第一个节点，没有则返回None
    """
    if head is None or head.next is None or head.next.next is None:
        return None
    slow = head.next
    fast = head.next.next
    while slow != fast:
        if fast.next is None or fast.next.next is None:  # 能走到空，肯定是无环的
            return None
        else:
            slow = slow.next
            fast = fast.next.next
    fast = head
    while slow != fast:
        slow = slow.next
        fast = fast.next
    return slow


if __name__ == '__main__':
    # Create LinkedList
    # node_arr = [ListNode(x) for x in range(10)]
    # node_arr[7].value = 0
    # # Connecting nodes
    # for i in range(9):
    #     node_arr[i].next = node_arr[i + 1]
    # output(node_arr[0])
    # output(reverse_linked_list(node_arr[0]))
    # output(delete_node_with_value(node_arr[0], 0))

    # head = ListNode(1)
    # head.next = ListNode(2)
    # head.next.next = ListNode(3)
    # head.next.next.next = ListNode(2)
    # head.next.next.next.next = ListNode(1)
    # print(is_palindrome_3(head))
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n1.next, n2.next = n2, n3
    output(n1)
    n3 = None
    output(n1)
