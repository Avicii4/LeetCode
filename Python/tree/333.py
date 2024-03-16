class Result:
    def __init__(self, node=None, size=0, max_val=float('-inf'), min_val=float('inf')):
        self.max_bst_head = node  # BST根节点
        self.max_num = size  # BST的size
        self.max_val = max_val  # BST的最大值
        self.min_val = min_val  # BST的最小值

def largest_BST_subtree(root):
    res = visit(root)
    return res.max_num if res else 0

def visit(node):
    if not node:
        return None

    left_info, right_info = None, None
    if node.left:
        left_info = visit(node.left)
    if node.right:
        right_info = visit(node.right)

    # 查看左子树的状态
    l_valid = (not left_info or (left_info.max_bst_head == node.left and left_info.max_val < node.val))
    # 查看右子树的状态
    r_valid = (not right_info or (right_info.max_bst_head == node.right and right_info.min_val > node.val))
    if l_valid and r_valid:   # 当前树为BST
        result = Result()
        result.max_bst_head = node
        result.max_val = node.val if not right_info else right_info.max_val
        result.min_val = node.val if not left_info else left_info.min_val
        result.max_num = (0 if not left_info else left_info.max_num) + (0 if not right_info else right_info.max_num) + 1
        return result

    # 本树非BST，那就看左右子树中较大的BST
    if left_info and right_info:
        return left_info if left_info.max_num > right_info.max_num else right_info
    if left_info:
        return left_info
    if right_info:
        return right_info

    return None
