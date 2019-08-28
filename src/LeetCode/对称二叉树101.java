package LeetCode;

/**
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 */
public class 对称二叉树101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right ==null)
            return true;
        if((left!=null && right ==null) || (left==null && right !=null))
            return false;

        if(left.val != right.val)
            return false;

        return isSymmetric(left.right,right.left) && isSymmetric(left.left,right.right);
    }
}
