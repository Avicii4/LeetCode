package problems.tree;

import problems.util.TreeNode;

public class LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return process(preorder, 0, inorder, 0, n);
    }

    private TreeNode process(int[] preorder, int preStart,
                             int[] inorder, int inStart, int width) {
        if (width==0){
            return null;
        }
        int splitValue = preorder[preStart];
        TreeNode curNode = new TreeNode(splitValue);
        if(width==1){
            return curNode;
        }
        int index = -1;
        for (int i = inStart; i < inStart + width; i++) {
            if (inorder[i] == splitValue) {
                index = i;
                break;
            }
        }
        curNode.left = process(preorder, preStart + 1,
                inorder, inStart, index - inStart);
        curNode.right = process(preorder, preStart + index - inStart + 1,
                inorder, index + 1, inStart + width - index-1);

        return curNode;
    }

    public static void main(String[] args) {
        LC105 s= new LC105();
//        int[] preorder = new int[]{3,9,20,15,7};
//        int[] inorder = new int[]{9,3,15,20,7};
        int[] preorder = new int[]{1,2};
        int[] inorder = new int[]{2,1};
        TreeNode r = s.buildTree(preorder,inorder);

    }
}
