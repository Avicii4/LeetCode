/**
 * Created by Harry Chou at 2019/9/6.
 * Description: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 */
public class PathSum {

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		// 已达到叶子结点
		if (root.left == null && root.right == null) {
			return sum - root.val == 0;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
