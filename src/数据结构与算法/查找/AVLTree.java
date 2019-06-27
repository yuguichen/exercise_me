package 数据结构与算法.查找;

/**
 * 平衡二叉树
 *      每个节点的左子树和右子树的高度最多差 1 ；
 */
public class AVLTree<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree
        private int hight;         // 深度

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            hight  = 0;
        }
    }

    private Node root;// 根节点

    public AVLTree(){}

    public void put(Key key, Value value){
        if(key == null)
            throw new IllegalArgumentException("key不能为空！");
        root = put(root, key,value);
    }

    private Node put(Node node, Key key, Value value){
        if(node == null)
            return new Node(key,value,1);

        int cmp = key.compareTo(node.key);
        if( cmp<0 )
            node.left = put(node.left,key,value);
        else if( cmp>0 )
            node.right = put(node.right,key,value);
        else
            node.val = value;
        node.size = size(node.left) + size(node.right)+1; // 更新节点数量
        return balance(node); // 对树进行平衡操作
    }

    /**
     * 使用函数避免 NullPointException
     * @param node 根节点
     * @return size
     */
    private int size(Node node){
        if(node == null)
            return 0;
        return node.size;
    }

    /**
     * 对节点进行平衡操作，保证节点的左右子树的深度差不超过1
     *   需要平衡的情况共四种：
     *       左左（单旋转）、右右（单旋转）
     *       左右（双旋转）、右左（双旋转）
     *
     * @param node
     */
    private Node balance(Node node){
        if(node == null)
            return node;

        if( hight(node.left) - hight(node.right) > 1){
            // = 保证在删除时出现左子树和右子树等高时使用单旋转
            if( hight(node.left.left) >= hight(node.left.right) )
                node = leftRotate(node);// 左左（单旋转）
            else
                node = leftDoubleRotate(node);// 左右（双旋转）
        } else if(hight(node.right) - hight(node.left) > 1){
            // = 保证在删除时出现左子树和右子树等高时使用单旋转
            if(hight(node.right.right) >= hight(node.right.left))
                node = rightRotate(node); // 右右（单旋转）
            else
                node = rightDoubleRotate(node); // 右左（双旋转）
        } else
            node.hight = Math.max(hight(node.left), hight(node.right))+1;
        return node;
    }

    /**
     * 计算节点高度
     *  空节点高度为-1，叶子节点高度为0
     * @param node
     * @return
     */
    private int hight(Node node){
        if(node == null)
            return -1;
        return Math.max(hight(node.left), hight(node.right))+1;
    }

    /**
     * 左左（单旋转）
     * @param node
     * @return
     */
    private Node leftRotate(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;

        node.hight = Math.max(hight(node.left), hight(node.right))+1;
        node.size = size(node.left) + size(node.right)+1; // 更新节点数量
        temp.hight = Math.max(hight(temp.left), hight(node.right))+1;
        temp.size = size(temp.left) + size(temp.right)+1; // 更新节点数量
        return temp;
    }

    /**
     * 右右（单旋转）
     * @param node
     * @return
     */
    private Node rightRotate(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;

        node.hight = Math.max(hight(node.left), hight(node.right))+1;
        node.size = size(node.left) + size(node.right)+1; // 更新节点数量
        temp.hight = Math.max(hight(temp.left), hight(node.right))+1;
        temp.size = size(temp.left) + size(temp.right)+1; // 更新节点数量
        return temp;
    }

    /**
     *  左右（双旋转）
     * @param node
     * @return
     */
    private Node leftDoubleRotate(Node node){
        node.left = rightRotate(node.left);
        return leftRotate(node);
    }

    /**
     * 右左（双旋转）
     * @param node
     * @return
     */
    private Node rightDoubleRotate(Node node){
        node.right = leftRotate(node.right);
        return rightRotate(node);
    }

}
