package LeetCode;

public class 二叉树最长路径 {

    public int longest(TreeNode root){
        if(root == null)
            return 0;

        int l = longest(root.left);
        int r = longest(root.right);
        int temp = l>r?l:r;

        int max = depth(root.left)+depth(root.right)+1;
        return temp>max?temp:max;
    }

    public int depth(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
