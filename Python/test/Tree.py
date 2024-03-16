from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class DifferentNode:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent


def build_tree():
    # 构建树
    #       1
    #      / \
    #     2   3
    #    / \ / \
    #   4  5 6  7
    root = TreeNode(1)
    root.left = TreeNode(2, TreeNode(4), TreeNode(5))
    root.right = TreeNode(3, TreeNode(6), TreeNode(7))
    return root


def build_tree_parent():
    node1 = DifferentNode(1)
    node2 = DifferentNode(2, parent=node1)
    node3 = DifferentNode(3, parent=node1)
    node4 = DifferentNode(4, parent=node2)
    node5 = DifferentNode(5, parent=node2)
    node6 = DifferentNode(6, parent=node3)
    node7 = DifferentNode(7, parent=node3)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node2.right = node5
    node3.left = node6
    node3.right = node7

    return node1  # 返回根节点


def preorder_traversal(node):
    if node:
        print(node.val, end=" ")
        preorder_traversal(node.left)
        preorder_traversal(node.right)


def preorder_traversal_no_recur(node):
    if node:
        stack = [node]
        while len(stack) > 0:
            pop_node = stack.pop()
            print(pop_node.val, end=" ")
            # 先压右，再压左
            if pop_node.right:
                stack.append(pop_node.right)
            if pop_node.left:
                stack.append(pop_node.left)


def inorder_traversal(node):
    if node:
        inorder_traversal(node.left)
        print(node.val, end=" ")
        inorder_traversal(node.right)


def inorder_traversal_no_recur(node):
    if node:
        stack = []
        while len(stack) > 0 or node:
            if node:
                stack.append(node)
                node = node.left
            else:
                pop_node = stack.pop()
                print(pop_node.val, end=" ")
                node = pop_node.right


def postorder_traversal(node):
    if node:
        postorder_traversal(node.left)
        postorder_traversal(node.right)
        print(node.val, end=" ")


def postorder_traversal_no_recur(node):
    if node:
        stack1, stack2 = [node], []
        while len(stack1) > 0:
            pop_node = stack1.pop()
            stack2.append(pop_node)
            # 先压左，后压右
            if pop_node.left:
                stack1.append(pop_node.left)
            if pop_node.right:
                stack1.append(pop_node.right)
        while len(stack2):
            print(stack2.pop().val, end=" ")


def postorder_traversal_no_recur_one_stack(node):
    h = node
    if node:
        stack = [node]
        while len(stack) > 0:
            c = stack[-1]
            if c.left and h != c.left and h != c.right:
                # 如果上一次出栈的既不是左孩子也不是右孩子，
                # 那么说明c所在子树没有被处理过，则先处理其左子树
                stack.append(c.left)
            elif c.right and h != c.right:
                # 如果上一次出栈的不是右孩子，则处理右子树
                stack.append(c.right)
            else:
                print(stack.pop().val, end=" ")
                h = c  # h 始终记录上一次出栈打印的节点


# 层次遍历
def level_traversal(node):
    if node is None:
        return
    queue = [node]
    while len(queue) > 0:
        pop_node = queue.pop(0)  # 出队
        print(pop_node.val, end=" ")
        if pop_node.left:
            queue.append(pop_node.left)
        if pop_node.right:
            queue.append(pop_node.right)


def tree_max_width_1(node):
    """
    求二叉树最大宽度，用额外字典
    """
    if node is None:
        return 0
    cur_level = 1  # 当前所在层
    cur_level_nodes = 0  # 当前层的宽度
    max_width = 0  # 全局最大层宽
    queue = [node]
    level_map = {node: 1}  # 记录节点和所在层
    while len(queue) > 0:
        pop_node = queue.pop(0)
        pop_node_level = level_map[pop_node]
        if pop_node.left:
            queue.append(pop_node.left)
            level_map[pop_node.left] = pop_node_level + 1
        if pop_node.right:
            queue.append(pop_node.right)
            level_map[pop_node.right] = pop_node_level + 1

        if cur_level == pop_node_level:
            cur_level_nodes += 1
        else:  # 弹出的节点已经是属于下一层的了，那么本层已经结束，统计宽度
            max_width = max(max_width, cur_level_nodes)
            cur_level += 1
            cur_level_nodes = 1
    # 由于是到了下一层才会更新max_width，所以最后一层的宽度还没有得到更新
    max_width = max(max_width, cur_level_nodes)
    return max_width


def tree_max_width_2(node):
    """
    不用额外字典，核心是cur_level_end以及next_level_end
    """
    if node is None:
        return 0
    queue = [node]
    cur_level_end = node  # 当前层的最右节点
    next_level_end = None  # 下一层的最右节点
    max_width = 0  # 全局最大层宽
    cur_level_nodes = 0  # 当前层的宽度

    while len(queue) > 0:
        pop_node = queue.pop(0)
        if pop_node.left:
            queue.append(pop_node.left)
            next_level_end = pop_node.left
        if pop_node.right:
            queue.append(pop_node.right)
            next_level_end = pop_node.right
        cur_level_nodes += 1
        if pop_node == cur_level_end:  # 如果弹出节点就是当前层最右的节点，则本层结束
            max_width = max(max_width, cur_level_nodes)
            cur_level_nodes = 0
            cur_level_end = next_level_end
    return max_width


def serialize_preorder(node):
    node_list = []
    pres(node, node_list)
    return node_list


def pres(node, node_list):
    if node is None:
        node_list.append(None)
    else:
        node_list.append(node.val)
        pres(node.left, node_list)
        pres(node.right, node_list)


def deserialize_preorder(node_list):
    # 注意这个node_list是一个队列
    if node_list is None or len(node_list) == 0:
        return None
    return pred(node_list)


def pred(node_list):
    value = node_list.pop(0)
    if value is None:
        return None
    head = TreeNode(value)
    head.left = pred(node_list)
    head.right = pred(node_list)
    return head


# 按层序列化
def serialize_levelorder(node):
    serial_result = []
    if node is None:
        serial_result.append(None)
    else:
        serial_result.append(node.val)
        queue = [node]
        while len(queue) > 0:
            pop_node = queue.pop(0)
            if pop_node.left:
                serial_result.append(pop_node.left.val)
                queue.append(pop_node.left)
            else:
                serial_result.append(None)
            if pop_node.right:
                serial_result.append(pop_node.right.val)
                queue.append(pop_node.right)
            else:
                serial_result.append(None)
    return serial_result


# 按层反序列化
def deserialize_levelorder(node_list):
    def generate_node(val):
        if val is None:
            return None
        return TreeNode(val)

    if node_list is None or len(node_list) == 0:
        return None
    head = generate_node(node_list.pop(0))
    queue = []
    if head:
        queue.append(head)
    while len(queue) > 0:
        node = queue.pop(0)
        node.left = generate_node(node_list.pop(0))
        node.right = generate_node(node_list.pop(0))
        if node.left:
            queue.append(node.left)
        if node.right:
            queue.append(node.right)
    return head


def get_predecessor(head: DifferentNode):
    if head:
        if head.right:
            p = head.right
            while p.left:
                p = p.left
            return p
        else:
            while head.parent and head.parent.left != head:
                head = head.parent
            return head.parent
    else:
        return None


def paper_fold(n: int):
    print_paper_fold(1, n, True)


def print_paper_fold(level, n, down):
    if level > n:
        return
    print_paper_fold(level + 1, n, True)  # 上面是凹下去的
    print("down" if down else 'up')
    print_paper_fold(level + 1, n, False)  # 下面是凸的


def is_balanced(head: TreeNode):
    return balance_process(head)[0]


def balance_process(head: TreeNode):
    if not head:
        return True, 0

    lbalanced, lheight = balance_process(head.left)
    rbalanced, rheight = balance_process(head.right)

    height = max(lheight, rheight) + 1
    balanced = lbalanced and rbalanced and abs(lheight - rheight) <= 1
    return balanced, height


def build_unbalanced_tree():
    # 构造不平衡的树
    #         1
    #        / \
    #       2   3
    #      /     \
    #     4       5
    #    /
    #   6
    node1 = TreeNode(1)
    node2 = TreeNode(2)
    node3 = TreeNode(3)
    node4 = TreeNode(4)
    node5 = TreeNode(5)
    node6 = TreeNode(6)

    node1.left = node2
    node1.right = node3
    node2.left = node4
    node3.right = node5
    node4.left = node6

    return node1  # 返回根节点


def max_height(head: TreeNode):
    return process_height(head)[0]


def process_height(head: TreeNode):
    if not head:
        return 0, 0

    lmax_distance, lheight = process_height(head.left)
    rmax_distance, rheight = process_height(head.right)

    max_distance = max(lheight + rheight + 1, lmax_distance, rmax_distance)
    height = max(lheight, rheight) + 1  # 本树的高度

    return max_distance, height


def is_full(root: TreeNode):
    node_num, height = process_full(root)
    return (1 << height) - 1 == node_num


def process_full(node: TreeNode):
    if not node:
        return 0, 0

    l_num, l_height = process_full(node.left)
    r_num, r_height = process_full(node.right)

    return l_num + r_num + 1, max(l_height, r_height) + 1


class BSTInfo:
    # 分别返回：当前子树最大的BST数量、当前子树是不是BST、当前子树里的最大值、最小值
    def __init__(self, max_num, is_bst, max_val, min_val):
        self.max_num = max_num
        self.is_bst = is_bst
        self.max_val = max_val
        self.min_val = min_val


def max_bst_node_num(head: TreeNode):
    if not head:
        return 0


def process_bst(head: TreeNode):
    if not head:
        # 空树返回空的BSTInfo，然后代码里再判空
        return BSTInfo(0, True, None, None)

    left_info = process_bst(head.left)
    right_info = process_bst(head.right)

    cur_max_val, cur_min_val = head.val, head.val
    if left_info.max_val:
        cur_max_val = max(cur_max_val, left_info.max_val)
    if left_info.min_val:
        cur_min_val = min(cur_min_val, left_info.min_val)
    if right_info.max_val:
        cur_max_val = max(cur_max_val, right_info.max_val)
    if right_info.min_val:
        cur_min_val = min(cur_min_val, right_info.min_val)

    # 先拿出左右子树的最大BST节点数
    cur_max_num = max(left_info.max_num, right_info.max_num)

    cur_is_bst = (left_info.is_bst and
                  right_info.is_bst and
                  left_info.max_val < head.val < right_info.min_val)
    if cur_is_bst:
        cur_is_bst = left_info.max_num + right_info.max_num + 1

    return BSTInfo(cur_max_num, cur_is_bst, cur_max_val, cur_min_val)


class Employee:
    def __init__(self, happy, subordinates):
        self.happy = happy
        self.subordinates = subordinates


def max_happiness(boss: Employee):
    if not boss:
        return 0
    return process_happiness(boss)


def process_happiness(x: Employee):
    # 返回内容：x来的
    if not x.subordinates:
        return x.happy, 0
    yes = x.happy
    no = 0
    for e in x.subordinates:  # 遍历所有直接下属员工
        yes_sub, no_sub = process_happiness(e)
        yes += no_sub  # 当前员工来，那么直接下属不可以来
        no += max(yes_sub, no_sub)  # 当前员工不来，那么直接下属可来可不来
    return yes, no


if __name__ == '__main__':
    r = build_unbalanced_tree()
    print(is_balanced(r))

    # 构建树
    # root = build_tree()
    # root = build_tree_parent()
    # print(get_predecessor(root).value)
    # paper_fold(3)
    # 先序遍历
    # print("Preorder traversal:")
    # preorder_traversal(root)
    # preorder_traversal_no_recur(root)
    # print()
    # 中序遍历
    # print("Inorder traversal:")
    # inorder_traversal(root)
    # print()
    # inorder_traversal_no_recur(root)
    # print()
    # 后序遍历
    # print("Postorder traversal:")
    # postorder_traversal(root)
    # print()
    # postorder_traversal_no_recur(root)
    # print()
    # postorder_traversal_no_recur_one_stack(root)
    # print(serialize_preorder(root))
    # a = [1, 2, 4, None, None, 5, None, None, 3, 6, None, None, 7, None, None]
    # t = deserialize_preorder(a)
    # print(serialize_preorder(t))
    # print(serialize_levelorder(root))
    # a = [1, 2, 3, 4, 5, 6, 7, None, None, None, None, None, None, None, None]
    # r = deserialize_levelorder(a)
    # print(serialize_levelorder(r))
