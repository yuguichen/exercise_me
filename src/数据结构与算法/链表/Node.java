package 数据结构与算法.链表;

public class Node<Key extends Comparable<Key>, Value> {
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
