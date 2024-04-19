package exam;

import problems.util.TreeNode;

class Info {
    public int maxDistance;
    public int height;

    public Info(int md, int h) {
        this.maxDistance = md;
        this.height = h;
    }
}

public class MaxDistance {
    public static int getMaxDistance(TreeNode root) {
        return process(root).maxDistance;
    }


    private static Info process(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + rightInfo.height + 1;
        // 若以本节点为中转，有可能的最大距离
        int maxDistance = Math.max(p3, Math.max(p1, p2));
        // 本树的高度
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(maxDistance, height);
    }
}



