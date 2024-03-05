class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


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


if __name__ == '__main__':
    # 构建树
    root = build_tree()
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
    a=[1, 2, 3, 4, 5, 6, 7, None, None, None, None, None, None, None, None]
    r=deserialize_levelorder(a)
    print(serialize_levelorder(r))