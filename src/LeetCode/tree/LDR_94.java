package LeetCode.tree;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94 二叉树的中序遍历
 *      左子树---> 根结点 ---> 右子树
 */
public class LDR_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = ldr_Recursion(root);
        return result;
    }

    // 递归方法
    public List<Integer> ldr_Recursion(TreeNode node){
        List<Integer> result = new ArrayList<>();
        if(node == null)
            return result;

        List<Integer> left = null;
        List<Integer> right = null;

        if(node.left != null){
            left = ldr_Recursion(node.left);
            result.addAll(left);
        }
        result.add(node.val);
        if(node.right != null){
            right = ldr_Recursion(node.right);
            result.addAll(right);
        }
        return result;
    }

    // 非递归方法
    public List<Integer> ldr_Iteration(TreeNode node){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(node != null || !stack.empty()){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }
}
