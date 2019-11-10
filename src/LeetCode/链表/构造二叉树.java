package LeetCode.链表;

import LeetCode.TreeNode;


public class 构造二叉树 {

    /**
     * 从前序与中序遍历序列构造二叉树
     * @param preorder 前序遍历
     * @param inorder 中序遍历
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root;

        root = buildTree(preorder,0,preorder.length-1,
                         inorder,0,inorder.length-1);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int prestart,int preEnd,
                          int[] inorder, int inStart, int inEnd ){

        if(prestart>preEnd || inStart>inEnd)
            return null;

        if(preEnd==prestart)
            return new TreeNode(preorder[prestart]);

        TreeNode node = new TreeNode(preorder[prestart]);
        int len =0;
        int index = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(preorder[prestart] == inorder[i]) {
                index = i;
                len = i-inStart;
                break;
            }
        }
        node.left = buildTree(preorder,prestart+1,prestart+len,
                              inorder,inStart,index-1);
        node.right = buildTree(preorder,prestart+len+1,preEnd,
                               inorder, index+1,inEnd);

        return node;

    }

}
