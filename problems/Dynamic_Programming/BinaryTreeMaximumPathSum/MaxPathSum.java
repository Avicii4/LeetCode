
/**
 * Created by Harry Chou at 2019/9/9.
 * Description: Given a non-empty binary tree, find the maximum path sum.For this problem,
 * a path is defined as any sequence of nodes from some starting node to any node in the tree
 * along the parent-child connections. The path must contain at least one node and does not
 * need to go through the root.
 */
public class MaxPathSum {

	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		recur(root);
		return maxSum;
	}

	private int recur(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int maxLeft = Math.max(recur(root.left), 0);
		int maxRight = Math.max(recur(root.right), 0);
		int currentSum = root.val + maxLeft + maxRight;

		maxSum = Math.max(currentSum, maxSum);

		return root.val + Math.max(maxLeft, maxRight);
	}
}
