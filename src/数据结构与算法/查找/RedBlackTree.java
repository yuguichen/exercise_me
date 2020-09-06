package 数据结构与算法.查找;

import java.util.NoSuchElementException;

/**
 * 红黑树
 *     1、红链接均为左链接；
 *     2、任意叶子结点(空节点)到根节点路径上黑链接数量相同；
 *     3、不存在连续两个红链接；
 * 便于理解，可先理解2-3查找树，红黑树是一种特定的2-3查找树，红链接对应3节点；
 */
public class RedBlackTree<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree
        private boolean color;     // 指向该节点链接的颜色

        public Node(Key key, Value val, int size,boolean color) {
            this.key = key;
            this.val = val;
            this.size = size;
            this.color = color;
        }
    }

    private Node root; // 根节点

    /* Constructor*/
    public RedBlackTree() {}


    public void put(Key key, Value value){
        if(key == null)
            throw new IllegalArgumentException("key不能为空！");
        root = put(root,key,value);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value){
        if(node == null)
            return new Node(key,value,1,RED);

        // 插入新节点
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            node.left = put(node.left,key,value);
        else if(cmp > 0)
            node.right = put(node.right,key,value);
        else
            node.val = value;

        // 处理节点颜色，保证平衡性
        if(isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);
        if(isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);
        if(isRed(node.left) && isRed(node.right))
            flipColor(node);

        node.size = size(node.left)+size(node.right)+1;
        return node;
    }

    /**
     * 删除最小节点
     */
    public void deleteMin(){
        if(root == null)
            throw new NoSuchElementException("RedBlackTree underflow");

        if(!isRed(root.right) && !isRed(root.left))
            root.color = RED;

        root = deleteMin(root);
        if(root != null)
            root.color = BLACK;
    }

    /**
     * 删除最小节点
     *  核心：在保证当前节点不是二节点的前提下，
     *        对三种情况讨论：
     *          1、左子节点不是二节点；
     *          2、左子节点是二节点，右子节点不是二节点；
     *          3、左右子节点都是二节点
     */
    private Node deleteMin(Node node){
        // 红黑树的性质决定左子节点为空的时候，右子节点一定为空
        if(node.left == null)
            return null;

        //左子节点为二节点（黑节点）
        if(!isRed(node.left) && !isRed(node.left.left)){
            flipColor(node);
            // 右子节点为三节点（红节点）
            if(isRed(node.right.left)){
                node.right = rightRotate(node.right);
                node = leftRotate(node);
                flipColor(node);
            }
        }

        node.left = deleteMin(node.left);

        // 处理节点颜色，保证平衡性
        if(isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);
        if(isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);
        if(isRed(node.left) && isRed(node.right))
            flipColor(node);

        return node;
    }

    /**
     * 删除任意节点
     *   核心：保证当前节点不是二节点，其他操作和删除最小节点相同
     * @param key
     */
    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("argument to delete is null");
        if (!contains(key)) return;

        if(!isRed(root.right) && !isRed(root.left))
            root.color = RED;

        root = delete(root,key);
        if(root != null)
            root.color = BLACK;
    }

    private Node delete(Node node, Key key){

        if(key.compareTo(node.key) < 0){
            //左子节点为二节点（黑节点）
            if(!isRed(node.left) && !isRed(node.left.left)){
                flipColor(node);
                // 右子节点为三节点（红节点）
                if(isRed(node.right.left)){
                    node.right = rightRotate(node.right);
                    node = leftRotate(node);
                    flipColor(node);
                }
            }
            node.left = delete(node.left,key);
        } else {
            // 保证左子节点和父节点为独立的两个节点
            if(isRed(node.left))
                node = rightRotate(node);

            // 上一步保证不会出现右子节点为空时，不会出现左子节点，即为叶子结点
            if(key.compareTo(node.key)==0 && node.right==null)
                return null;

            // 右子节点是2-节点
            if(!isRed(node.right) && !isRed(node.right.left)){
                flipColor(node);
                // 左子节点不是2-节点,从左子节点借一个节点保证右子节点不是2-节点
                if(isRed(node.left.left)){
                    node = rightRotate(node);
                    flipColor(node);
                }
            }

            if(key.compareTo(node.key)==0){
                Node min = findMin(node.right);
                node.key = min.key;
                node.val = min.val;
                node.right = deleteMin(node.right);
            } else {
                node.right = delete(node.right,key);
            }
        }

        // 处理节点颜色，保证平衡性
        if(isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);
        if(isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);
        if(isRed(node.left) && isRed(node.right))
            flipColor(node);

        return node;
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node node, Key key){
        if(key == null)
            throw new IllegalArgumentException("argument to get is null");

        while(node != null){
            int cmp = key.compareTo(node.key);
            if(cmp<0)
                node = node.left;
            else if(cmp>0)
                node = node.right;
            else
                return node.val;
        }
        return null;
    }

    /**
     * 判断是否存在key
     * @param key
     * @return
     */
    public boolean contains(Key key){
        return get(key) != null;
    }

    /**
     * 判断节点颜色, 空节点默认黑色
     * @return
     */
    private boolean isRed(Node node){
        if(node == null)
            return false;
        return node.color;
    }

    /**
     * 左旋
     * @param node
     * @return
     */
    private Node leftRotate(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;

        temp.color = node.color;
        node.color = RED;
        temp.size = node.size;
        node.size = 1+size(node.left)+size(node.right);

        return temp;
    }

    /**
     * 右旋
     * @param node
     * @return
     */
    private Node rightRotate(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;

        temp.color = node.color;
        node.color = RED;
        temp.size = node.size;
        node.size = 1+size(node.left)+size(node.right);

        return temp;
    }

    /**
     * 转换节点颜色
     * @param node
     */
    private void flipColor(Node node){
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
    }

    /**
     * 使用函数避免 NullPointException
     * @param node
     * @return size
     */
    private int size(Node node){
        if(node == null)
            return 0;
        return node.size;
    }

    private Node findMin(Node node){
        if(node == null)
            throw new IllegalArgumentException("argument is null");
        while(node.left != null)
            node = node.left;
        return node;
    }
}
