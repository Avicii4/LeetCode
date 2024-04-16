package problems.tree;

import problems.util.TreeNode;

import java.util.*;

// 每一层的宽度被定义为该层最左和最右的非空节点（即，两个端点）之间的长度
// 本题应该使用类似堆来解，每层
public class LC662 {

    private List<Integer> ids;   // 记录每一层最左边的非空节点的位置

    public int widthOfBinaryTree(TreeNode root) {
        this.ids = new ArrayList<>();
        return dfs(root, 0, 0);
    }

    private int dfs(TreeNode root, int depth, int id) {
        if (root == null) {
            return 0;
        }
        if (ids.size() == depth) {
            // 当前节点是当前层最左非空节点
            ids.add(id);
        }
        int width = id - ids.get(depth);
        return Math.max(width + 1,
                Math.max(dfs(root.left, depth + 1, 2 * width),  // 左孩子
                        dfs(root.right, depth + 1, 2 * width + 1)));
    }


    public static void main(String[] args) {
        Integer[] levelOrder = {1, 3, 2, 5, null, null, 9, 6, null, 7};
        TreeNode root = TreeNode.buildTree(levelOrder);
        System.out.println(new LC662().widthOfBinaryTree(root));
    }
}
