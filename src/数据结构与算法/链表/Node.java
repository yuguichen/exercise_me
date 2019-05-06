package 数据结构与算法.链表;

public class Node {
     int val;
     Node next;
     Node(int x) { val = x; }

     public static Node getNodeList(int[] test){
          Node head = new Node(test[0]);
          Node cur = head;
          for(int i= 1;i<test.length;i++){
               cur.next = new Node(test[i]);
               cur = cur.next;
          }
          return head;
     }
}
