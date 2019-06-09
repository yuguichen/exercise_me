package LeetCode.链表;

import java.util.Set;
import java.util.TreeSet;

class ListNode {
     // 节点类
     class Node{
          int val;
          Node next;
          Node(int x) { val = x; }

         public  Node getNodeList(int[] test){
             Node head = new Node(test[0]);
             Node cur = head;
             for(int i= 1;i<test.length;i++){
                 cur.next = new Node(test[i]);
                 cur = cur.next;
             }
             return head;
         }
     }

     /**
      * 判断链表是否有环,通过双指针的方式寻找
      * @param head
      * @return
      */
     public boolean hasCycle(Node head){
          if(head == null)
               return false;

          Node fast = head;
          Node slow = head;

          while(fast!=null && fast.next!=null){
               fast = fast.next.next;
               slow = slow.next;

               if(fast==slow)
                    return true;
          }
          return false;
     }

     /**
      * 判断是否有环以及确定环的位置
      * @param head
      * @return
      */
     public static Node detectCycle(Node head){
          if(head == null)
               return null;

          Node fast = head;
          Node slow = head;
          boolean hasCycle = false;
          //先判断是否有环
          while(fast!=null && fast.next!=null){
               fast = fast.next.next;
               slow = slow.next;
               if(fast==slow){
                    hasCycle = true;
                    break;
               }
          }

          //如果有环，找到环的入口
          if(hasCycle){
               Node cur = head;
               while(cur!=slow){
                    cur = cur.next;
                    slow = slow.next;
               }
               return cur;
          }
          return null;
     }


     /**
      * 删除有序链表中重复的节点
      * 示例 1:
      *      输入: 1->2->3->3->4->4->5
      *      输出: 1->2->5
      * 示例 2:
      *      输入: 1->1->1->2->3
      *      输出: 2->3
      */
     public Node removeDuplicates(Node head){
          if(head == null||head.next==null)
               return head;

          //删除和头结点重复的节点
          while(head.val==head.next.val){
               int val = head.val;
               while(head!=null && head.val==val)
                    head = head.next;

               if(head == null||head.next==null)
                    return head;
          }

          Node slow = head;
          Node fast = head.next;
          int val = slow.val;

          while(fast!=null&&fast.next!=null){
               if(fast.val==fast.next.val)
                    val = fast.val;

               while(fast!=null&&val == fast.val)
                    fast = fast.next;

               if(fast == null||fast.next==null){
                    slow.next = fast;
                    return head;
               } else if(fast.val!=fast.next.val){
                    slow.next = fast;
                    slow = fast;
                    fast = fast.next;
               }
          }
          return head;
     }

     /**
      * 删除链表中倒数第n个节点
      */
     public Node removeNthFromEnd(Node head, int n){
          Node fast = head;
          Node slow = head;

          for(int i=0;i<n;i++)
               fast = fast.next;

          if(fast.next==null)
               return head.next;

          while(fast.next!=null){
               fast = fast.next;
               slow = slow.next;
          }

          slow.next = slow.next.next;
          return head;
     }


     /**
      * 92、反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
      * 说明:    1 ≤ m ≤ n ≤ 链表长度。
      *
      * 示例:
      *   输入: 1->2->3->4->5->NULL, m = 2, n = 4
      *   输出: 1->4->3->2->5->NULL
      */
     public static Node reverseBetween(Node head, int m, int n) {
          int i = 1;
          Node cur = head;
          Node node = null;
          Node start = null;
          Node prev = null;

          if(m==n) //不用旋转
               return head;

          if(m==1){ //从头旋转
               while(i<n){
                    node = head.next.next;
                    head.next.next = cur;
                    cur = head.next;
                    head.next = node;
                    i++;
               }
               return cur;
          }else{ //从指定位置旋转
               while(i<n){
                    if(i<m){ //移动到旋转开始的位置
                         i++;
                         prev = cur;
                         cur = cur.next;
                         start = cur;
                         continue;
                    }
                    node = start.next.next;
                    start.next.next = cur;
                    cur = start.next;
                    start.next = node;
                    prev.next = cur;
                    i++;
               }
               return head;
          }
     }

     public  Node reverse(Node head){
          Node prev = new Node(0);
          Node node = new Node(0);
          prev.next = head;
          while (head.next!=null){
               node.next = head.next.next;
               head.next.next = prev.next;
               prev.next = head.next;
               head.next = node.next;
          }
          return prev.next;
     }

     /**
      * 通过将链表中的值存储到set集合中，若当前访问的值在set中已经存在，则删除当前节点
      * 节省时间，需要额外空间
      */
     public static void deleteDuplecate_Set(Node head){
          Set<Integer> set = new TreeSet<>();
          Node temp = head;
          Node pre = null;

          while(temp!=null){
               if(set.contains(temp.val)) {
                    pre.next = temp.next;
               } else {
                    set.add(temp.val);
                    pre = temp;
               }
               temp = temp.next;
          }
     }

     /**
      * 通过双重循环遍历：
      *      外循环正常遍历链表，内循环从链表头开始循环，只要遇到相同的节点就删除同时内循环结束。
      * 节省空间，时间复杂度高
      */
     public static void deleteDuplecate_Foreach(Node head){
          Node cur = head;
          Node pre_cur = null;
          boolean flag = false;
          while(cur!=null){
               Node p = head;
               while(p!=cur){
                    if(p.val == cur.val){
                         pre_cur.next = cur.next;
                         cur = cur.next;
                         flag = true;
                         break;
                    } else{
                         p = p.next;
                    }
               }
               if(flag){
                    flag = false;
               } else {
                    pre_cur = cur;
                    cur = cur.next;
               }
          }
     }


     /**
      * 找到链表中倒数第k个节点
      */
     public static Node find_K_Elem(Node head,int k){
          if(k<1)
               return null;

          Node fast = head;
          for(int i=1; i<k && fast!=null; i++){
               fast = fast.next;
          }
          if(fast == null){
               System.out.println("k超出了链表的长度，该节点不存在");
               return null;
          }
          Node slow = head;
          while (fast.next!=null){
               fast = fast.next;
               slow = slow.next;
          }

          return slow;
     }


}
