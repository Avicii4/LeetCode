package test;

import problems.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSerialization {

    // 先序遍历序列化代码
    public List<Integer> serializePreorder(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        pres(root, nodeList);
        return nodeList;
    }

    private void pres(TreeNode node, List<Integer> nodeList) {
        if (node == null) {
            nodeList.add(null);
        } else {
            nodeList.add(node.val);
            pres(node.left, nodeList);
            pres(node.right, nodeList);
        }
    }

    // 先序遍历反序列化代码
    public TreeNode deserializePreorder(List<Integer> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) {
            return null;
        }
        return pred(nodeList);
    }

    private TreeNode pred(List<Integer> nodeList) {
        if (nodeList.isEmpty()) {
            return null;
        }
        Integer value = nodeList.remove(nodeList.size() - 1);
        if (value == null) {
            return null;
        }
        TreeNode head = new TreeNode(value);
        head.left = pred(nodeList);
        head.right = pred(nodeList);
        return head;
    }

    // 层序遍历的序列化
    public static Queue<String> serializeLevelorder(TreeNode head) {
        Queue<String> ans = new LinkedList<>();
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.val));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll();
                if (head.left != null) {
                    ans.add(String.valueOf(head.left.val));
                    queue.add(head.left);
                } else {
                    ans.add(null);
                }
                if (head.right != null) {
                    ans.add(String.valueOf(head.right.val));
                    queue.add(head.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    // 层序遍历的反序列化
    public TreeNode deserialization(Queue<String> list) {
        if (list == null || list.isEmpty())
            return null;
        TreeNode head = generateNode(list.poll());
        Queue<TreeNode> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();//读入节点
            cur.left = generateNode(list.poll());
            cur.right = generateNode(list.poll());
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return head;
    }

    private static TreeNode generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }

}
