import java.util.Stack;

public class KthNode {
    TreeNode findNode(TreeNode pRoot, int k) {
        int index = 0;
        if (index >= k || pRoot == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || pRoot != null) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                index++;
                if (index == k) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }
        return null;
    }

}
