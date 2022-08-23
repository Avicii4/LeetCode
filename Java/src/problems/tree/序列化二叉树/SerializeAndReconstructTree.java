/**
 * Created by Harry Chou at 2019/7/22.
 */
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {
	String Serialize(TreeNode root) {
		if (root == null) {
			return "#,";
		}
		String res = root.val + ",";
		res += Serialize(root.left);
		res += Serialize(root.right);
		return res;
	}

	TreeNode Deserialize(String str) {
		String[] values = str.split(",");
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < values.length; i++) {
			queue.offer(values[i]);
		}
		return reconstruct(queue);
	}

	private TreeNode reconstruct(Queue<String> queue) {
		String val = queue.poll();
		if ("#".equals(val)) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = reconstruct(queue);
		node.right = reconstruct(queue);
		return node;
	}
}
