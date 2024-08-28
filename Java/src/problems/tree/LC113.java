package problems.tree;

import problems.util.TreeNode;

import java.util.*;

public class LC113 {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> curList = new ArrayList<>();
        process(root, res, curList, targetSum);
        return res;
    }

    private static void process(TreeNode node, List<List<Integer>> res,
                                List<Integer> curList, int targetSum) {
        targetSum -= node.val;
        curList.add(node.val);
        if (node.left == null && node.right == null && targetSum == 0) {
            res.add(new ArrayList<>(curList));
        }
        if (node.left != null) {
            process(node.left, res, curList, targetSum);
        }
        if (node.right != null) {
            process(node.right, res, curList, targetSum);
        }
        // 回溯，从列表中移除掉最后一个元素
        removeLastOccurrence(curList, node.val);
    }

    private static void removeLastOccurrence(List<Integer> list, int x) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == x) {
                list.remove(i);
                return;
            }
        }
    }

    /**
     * 解法二，其实和我原来的算法一样，但是上面的回溯移除元素比较麻烦，
     * 所以采用队列的结构，代码精简了
     */
    public static List<List<Integer>> pathSum_2(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(root, ret, path, targetSum);
        return ret;
    }

    private static void dfs(TreeNode root, List<List<Integer>> ret, Deque<Integer> path, int targetSum) {
        if (root == null) {
            return;
        }

        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, ret, path, targetSum);
        dfs(root.right, ret, path, targetSum);
        path.pollLast();
    }


    public static void main(String[] args) {
        //Integer[] values = new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        Integer[] values = new Integer[]{1, -2, -3, 1, 3, -2, null, -1};
        TreeNode root = TreeNode.buildTree(values);
        //int target = 22;
        int target=0;
        System.out.println(pathSum(root, target));
        System.out.println(pathSum_2(root, target));
    }

}
