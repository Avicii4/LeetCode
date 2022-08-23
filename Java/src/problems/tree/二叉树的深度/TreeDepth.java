/**
 * Created by Harry Chou at 2019/6/12.
 */
public class TreeDepth {
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int getDepthWithoutRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }

        TreeNode current = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur, last;
        int level = 0;
        while (!queue.isEmpty()) {
            // 记录本层已经遍历的节点个数
            cur = 0;
            // 当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
            last = queue.size();
            // 当还没有遍历到本层最后一个节点时循环
            while (cur < last) {
                // 出队一个元素
                current = queue.poll();
                cur++;
                // 把当前节点的左右节点入队（如果存在的话）
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            // 每遍历完一层level+1
            level++;
        }
        return level;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
