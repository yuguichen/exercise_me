package 数据结构与算法.链表;

import java.util.Set;
import java.util.TreeSet;

public class NodeList {

    public static void main(String[] args){
        int[] test = {21,10,26,5,35,33,27,6,29,5,9,20,14,14,2,13,-24,21,23,21,5};
        Node head = Node.getNodeList(test);

        Node cur = head;
        while(cur!=null){
            System.out.print(cur.val+",");
            cur = cur.next;
        }
        System.out.println();
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
