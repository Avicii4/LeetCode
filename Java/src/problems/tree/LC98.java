package problems.tree;

import problems.util.TreeNode;

public class LC98 {
    public static boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    private static TInfo process(TreeNode root) {
        if (root == null) {
            return new TInfo(true, null, null);
        }
        TInfo leftInfo = process(root.left);
        TInfo rightInfo = process(root.right);

        boolean curIsBST = leftInfo.isBST && rightInfo.isBST;
        int curMinVal = root.val, curMaxVal = root.val;
        if (leftInfo.minVal != null) {
            curMinVal = Math.min(leftInfo.minVal, curMinVal);
        }
        if (rightInfo.minVal != null) {
            curMinVal = Math.min(rightInfo.minVal, curMinVal);
            curIsBST = curIsBST && (root.val < rightInfo.minVal);
        }
        if (leftInfo.maxVal != null) {
            curMaxVal = Math.max(leftInfo.maxVal, curMaxVal);
            curIsBST = curIsBST && (root.val > leftInfo.maxVal);
        }
        if (rightInfo.maxVal != null) {
            curMaxVal = Math.max(rightInfo.maxVal, curMaxVal);
        }

        return new TInfo(curIsBST, curMinVal, curMaxVal);

    }

    public static void main(String[] args) {
        Integer[] arr = {5, 1, 4, null, null, 3, 6};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(isValidBST(root));
    }
}


class TInfo {
    public boolean isBST;
    public Integer minVal;
    public Integer maxVal;

    TInfo(boolean isBST, Integer minVal, Integer maxVal) {
        this.isBST = isBST;
        this.minVal = minVal;
        this.maxVal = maxVal;
    }
}
