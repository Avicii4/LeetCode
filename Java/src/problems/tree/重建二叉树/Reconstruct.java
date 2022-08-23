/**
 * Created by Harry Chou at 2019/4/15.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;

public class Reconstruct {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int len = pre.length;
        if (len == 0) {
            return null;
        }
        TreeNode newNode = new TreeNode(pre[0]);
        int location = findElement(in, pre[0]);

        int[] leftPre = new int[location];
        System.arraycopy(pre, 1, leftPre, 0, location);
        int[] leftIn = new int[location];
        System.arraycopy(in, 0, leftIn, 0, location);
        int[] rightPre = new int[len - location - 1];
        System.arraycopy(pre, location + 1, rightPre, 0, len - location - 1);
        int[] rightIn = new int[len - location - 1];
        System.arraycopy(in, location + 1, rightIn, 0, len - location - 1);

        newNode.left = reConstructBinaryTree(leftPre, leftIn);
        newNode.right = reConstructBinaryTree(rightPre, rightIn);

        return newNode;
    }

    private int findElement(int[] arr, int target) {
        int location = 0;
        while (arr[location] != target) {
            location++;
        }
        return location;
    }
}