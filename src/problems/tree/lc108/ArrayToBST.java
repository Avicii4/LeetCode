package problems.tree.lc108;

import problems.util.TreeNode;

/**
 * Created by Harry Chou at 2018/12/8.
 * Description: Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST. For this problem, a height-balanced
 * binary tree is defined as a binary tree in which the depth of the two
 * subtrees of every node never differ by more than 1.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums, 0, nums.length - 1);
    }

    public TreeNode insert(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = insert(nums, start, mid - 1);
        node.right = insert(nums, mid + 1, end);
        return node;
    }
}