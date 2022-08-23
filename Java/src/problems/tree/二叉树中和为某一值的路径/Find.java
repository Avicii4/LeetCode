/**
 * Created by Harry Chou at 2019/5/19.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;

public class Find {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        find(result, new ArrayList<Integer>(), root, target);
        return result;
    }

    public void find(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, TreeNode root, int target) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                result.add(path);
            }
            return;
        }
        ArrayList<Integer> path2 = new ArrayList<>();
        path2.addAll(path);
        if (root.left != null) {
            find(result, path, root.left, target - root.val);
        }
        if (root.right != null) {
            find(result, path2, root.right, target - root.val);
        }
    }
}