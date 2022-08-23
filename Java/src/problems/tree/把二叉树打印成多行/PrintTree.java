/**
 * Created by Harry Chou at 2019/7/22.
 */

import java.util.ArrayList;

public class PrintTree {
	public ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		recur(pRoot, 1, res);
		return res;
	}

	private void recur(TreeNode node, int depth, ArrayList<ArrayList<Integer>> list) {
		if (node == null) {
			return;
		}
		if (depth > list.size()) {
			list.add(new ArrayList<Integer>());
		}
		list.get(depth - 1).add(node.val);

		recur(node.left, depth + 1, list);
		recur(node.right, depth + 1, list);
	}
}
