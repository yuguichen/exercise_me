package LeetCode;

import java.util.*;

public class 二叉树遍历 {

    /**
     *    层序遍历
     */
    public List<TreeNode> levelOrder(TreeNode root){
        LinkedList<TreeNode> list = new LinkedList<>();
        List<TreeNode> result = new ArrayList<>();
        list.add(root);

        while(!list.isEmpty()){
            TreeNode node = list.poll();
            result.add(node);
            if(node.left!=null)
                list.add(node.left);
            if(node.right!=null)
                list.add(node.right);
        }
        return result;
    }

    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
     * 返回其自底向上的层次遍历为：
     *
         * [
         *   [15,7],
         *   [9,20],
         *   [3]
         * ]
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 递归方法（类似深度优先遍历）
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result,0,root);
        Collections.reverse(result);
        return result;
    }

    public void dfs(List<List<Integer>> result,int depth, TreeNode node){
        if(node == null)
            return;

        if(depth+1 > result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(depth).add(node.val);
        if(node.left!=null)
            dfs(result,depth+1,node.left);
        if(node.right!=null)
            dfs(result,depth+1,node.right);

    }

    /**
     * 查找每层最右结点
     * @param root
     * @return
     */
    public List<Integer> findRightNode(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(i==size-1)
                    result.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return result;
    }


}
