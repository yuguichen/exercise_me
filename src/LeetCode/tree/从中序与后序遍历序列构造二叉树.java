package LeetCode.tree;

import LeetCode.TreeNode;

public class 从中序与后序遍历序列构造二叉树 {
    private int postIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length || inorder.length==0)
            return null;

        postIndex = postorder.length-1;
        TreeNode root = buildTree(inorder,postorder,0,inorder.length-1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,int left,int right){
        if(left > right || postIndex<0)
            return null;

        int val = postorder[postIndex--];
        TreeNode node = new TreeNode(val);

        int cur = 0;
        for(int i=left; i<=right; i++){
            if(inorder[i] == val){
                cur = i;
                break;
            }
        }

        node.right = buildTree(inorder,postorder,cur+1,right);
        node.left = buildTree(inorder,postorder,left,cur-1);
        return node;
    }
}
