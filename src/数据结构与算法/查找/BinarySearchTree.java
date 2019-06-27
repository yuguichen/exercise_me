package 数据结构与算法.查找;

/**
 * 二叉查找树
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;// 根节点

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BinarySearchTree(){}

    /**
     * 添加方法
     * @param key 键
     * @param val 值
     */
    public void put(Key key, Value val){
        if(key == null)
            throw new IllegalArgumentException("key不能为空！");
        root = put(root,key,val);
    }

    /**
     * 向node为根节点的二叉树中插入新节点
     * @param node 根节点
     * @param key 新节点-键
     * @param val 新节点-值
     * @return Node
     */
    private Node put(Node node, Key key, Value val){
        if(node == null)
            return new Node(key,val,1);

        int cmp = key.compareTo(node.key);
        if( cmp<0 )
            node.left = put(node.left,key,val);
        else if( cmp>0 )
            node.right = put(node.right,key,val);
        else
            node.val = val;
        node.size = size(node.left) + size(node.right)+1;
        return node;
    }

    /**
     * 查找方法
     * @param key 键
     * @return Value
     */
    public Value get(Key key){
        if(key == null)
            throw new IllegalArgumentException("key不能为空！");

        return find(root,key);
    }

    /**
     * 在node为根节点的树中查找key对应节点
     * @param node 根节点
     * @param key 键
     * @return Value
     */
    private Value find(Node node, Key key){
        if(node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if( cmp<0 )
            return find(node.left,key);
        else if( cmp>0 )
            return find(node.right,key);
        else
            return node.val;
    }

    /**
     * 删除方法
     * @param key 键
     */
    public void delete(Key key){
        root = delete(root,key);
    }

    /**
     * 删除node为根节点的树中键为key的节点
     * @param node 根节点
     * @param key 键
     * @return Node
     */
    private Node delete(Node node,Key key){
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if( cmp<0 )
            node = delete(node.left,key);
        else if( cmp>0 )
            node = delete(node.right,key);
        else {
            if(node.left == null)
                return node.right;
            if(node.right == null)
                return node.left;
            Node min = findMin(node.right);
            min.right = deleteMin(node.right);
            min.left = node.left;
            node = min;
        }
        node.size = size(node.right)+size(node.right)+1;
        return node;
    }

    /**
     * 找到 node为根节点的树中 最小节点
     * @param node 根节点
     * @return Node
     */
    private Node findMin(Node node){
        if(node == null)
            return null;
        if(node.left != null)
            return findMin(node.left);
        else
            return node;
    }

    /**
     * 删除 node为根节点的树中 最小节点
     * @param node 根节点
     * @return Node
     */
    private Node deleteMin(Node node){
        if(node == null)
            return null;

        if(node.left != null){
            node.left = deleteMin(node.left);
            node.size = size(node.left) + size(node.right)+1;
            return node;
        }
        else
            return node.right;
    }

    /**
     * 返回树的节点个数（大小）
     * @return size
     */
    public int size(){
        if(root == null)
            return 0;
        return root.size;
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
     * 前序优先遍历(递归实现)：
     *      根结点 ---> 左子树 ---> 右子树
     * D=Degree L=Left R=Right（DLR）
     */
    public Object[] dlr(){
        return dlr(root);
    }

    private Object[] dlr(Node node){
        Object[] vals = new Object[node.size];
        Object[] left;
        Object[] right;

        int i = 0;
        vals[i++] = node.val;

        if(node.left != null){
            left = dlr(node.left);
            for(int j=0; j<left.length; j++){
                vals[i++] = left[j];
            }
        }
        if(node.right != null){
            right = dlr(node.right);
            for (Object aRight : right) {
                vals[i++] = aRight;
            }
        }

        return vals;
    }

    /**
     * 前序优先遍历(非递归实现)：
     *      根结点 ---> 左子树 ---> 右子树
     * D=Degree L=Left R=Right（DLR）
     */
    public Object[] dlr2(){
        int legth = root.size;
        Object[] vals = new Object[legth];
        BinarySearchTree.Node[] top = new BinarySearchTree.Node[legth];
        Node temp = root;
        int i = 0;
        int t = 0;

        // 通过入栈出栈的方式来实现遍历：假定top数组为栈
        while(i < legth){
            while(temp != null){
                vals[i++] = temp.val;
                top[t++] = temp;
                temp = temp.left;
            }

            temp = top[--t].right;
        }
        return vals;
    }


    /**
     * 中序优先遍历
     *      左子树---> 根结点 ---> 右子树
     * @return
     */
    public Object[] ldr(){
        return ldr(root);
    }

    public Object[] ldr(Node node){
        Object[] vals = new Object[node.size];
        Object[] left;
        Object[] right;
        int i = 0;

        if(node.left != null){
            left = ldr(node.left);
            for(int j=0; j<left.length; j++){
                vals[i++] = left[j];
            }
        }
        vals[i++] = node.val;

        if(node.right != null){
            right = ldr(node.right);
            for (Object aRight : right) {
                vals[i++] = aRight;
            }
        }

        return vals;
    }
}

