package LeetCode.链表;

import LeetCode.ListNode;

public class 合并两个有序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode cur = newNode;
        while(l1!=null && l2!=null){
           if(l1.val>l2.val){
               cur.next = l2;
               l2 = l2.next;
           } else {
               cur.next=l1;
               l1 = l1.next;
           }
            cur = cur.next;
        }
        if(l1!=null)
            cur.next =l1;
        if(l2!=null)
            cur.next = l2;

        return newNode.next;
    }
}
