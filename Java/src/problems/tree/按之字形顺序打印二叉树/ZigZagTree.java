/**
 * Created by Harry Chou at 2019/7/22.
 */

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTree {
	public ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (pRoot == null) {
			return res;
		}
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(pRoot);
		while (!s1.empty() || !s2.empty()) {
			if (!s1.empty()) {
				ArrayList<Integer> list = new ArrayList<>();
				while (!s1.empty()) {
					TreeNode node = s1.pop();
					list.add(node.val);
					if (node.left != null) {
						s2.push(node.left);
					}
					if (node.right != null) {
						s2.push(node.right);
					}
				}
				res.add(list);
			}
			if (!s2.empty()) {
				ArrayList<Integer> list = new ArrayList<>();
				while (!s2.empty()) {
					TreeNode node = s2.pop();
					list.add(node.val);
					if (node.right != null) {
						s1.push(node.right);
					}
					if (node.left != null) {
						s1.push(node.left);
					}
				}
				res.add(list);
			}
		}
		return res;
	}
}
