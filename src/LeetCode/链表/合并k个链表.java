package LeetCode.链表;

import LeetCode.ListNode;

public class 合并k个链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length == 0)
            return null;

        while(length >1){
            ListNode[] newLists;
            if(length%2 == 1) {
                newLists = new ListNode[(length/2)+1];
            } else {
                newLists = new ListNode[length/2];
            }

            for(int i=0;i<newLists.length;i++){
                if(2*i+1<length){
                    newLists[i] = mergeTwoLists(lists[2*i],lists[2*i+1]);
                } else {
                    newLists[i] = lists[2*i];
                }
            }
            length = newLists.length;
            lists = newLists;
        }

        return lists[0];
    }

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
