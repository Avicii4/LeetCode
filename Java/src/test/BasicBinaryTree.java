package test;

import problems.util.TreeNode;

import java.util.*;

public class BasicBinaryTree {

    // 先序非递归
    public static void preOrderUnRecur(TreeNode head) {
        System.out.println("Preorder");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    // 中序非递归
    public static void inOrderUnRecur(TreeNode head) {
        System.out.println("Inorder");
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty() || head != null) {
                if (head != null) { // 左边如果一直有节点，就一直压入栈
                    stack.push(head);
                    head = head.left;
                } else {  // 左侧已空，则弹出节点，并向右一步
                    head = stack.pop();
                    System.out.println(head.val + " ");
                    head = head.right;
                }
            }
        }
    }


    // 后序非递归，双栈版本
    public static void postOrderUnRecur_1(TreeNode head) {
        System.out.println("Preorder");
        if (head != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().val + " ");
            }
        }
    }

    // 后序非递归，单栈版本
    public static void postOrderUnRecur_2(TreeNode head) {
        if (head != null) {
            TreeNode h = head;
            TreeNode c = null;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    // 如果上一次出栈的既不是左孩子也不是右孩子
                    // 那么说明c所在子树没有被处理过，则先处理其左子树
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    // 如果上一次出栈的不是右孩子，则处理右子树
                    stack.push(c.right);
                } else {
                    System.out.println(stack.pop().val + " ");
                    h = c; // h 始终记录上一次出栈打印的节点
                }
            }
        }
    }

    // 按层遍历
    public static void levelOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    // 求树的最大宽度，用额外的字典
    public static int treeMaxWidth1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(head, 1);
        int curLevel = 1; // 当前层数
        int curLevelNodes = 0;  // 当前层节点数
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curNodeLevel = map.get(cur);
            if (cur.left != null) {
                queue.add(cur.left);
                map.put(cur.left, curNodeLevel + 1);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                map.put(cur.right, curNodeLevel + 1);
            }

            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            } else {
                // 弹出的节点已经是属于下一层的了，那么本层已经结束，统计宽度
                maxWidth = Math.max(maxWidth, curLevelNodes);
                curLevel++;
                curLevelNodes = 0;
            }
        }
        // 由于是到了下一层才会更新maxWidth，所以最后一层的宽度还没有得到更新
        maxWidth = Math.max(maxWidth, curLevelNodes);
        return maxWidth;
    }


    // 求树的最大宽度，不用额外字典
    public static int treeMaxWidth2(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode nextLevelEnd = null;  // 下一层的最右节点
        TreeNode curLevelEnd = head; //  当前层的最右节点
        int curLevelNode = 0;  // 当前层的宽度
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevelEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextLevelEnd = cur.right;
            }

            curLevelNode++;
            if (cur == curLevelEnd) { // 如果弹出节点就是当前层最右的节点，则本层结束
                maxWidth = Math.max(maxWidth, curLevelNode);
                curLevelEnd = nextLevelEnd;
                curLevelNode = 0;
            }
        }
        return maxWidth;
    }
}
