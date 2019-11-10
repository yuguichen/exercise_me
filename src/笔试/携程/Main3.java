package 笔试.携程;

import java.util.Scanner;

public class Main3 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        if(head == null || head.next == null)
            return head;

        ListNode pre = head;
        ListNode next = pre.next;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode temp = start;

        while(pre !=null && pre.val<=m){
            temp = temp.next;
            pre = pre.next;
            if(next!=null)
                next = next.next;
            else
                return head;
        }

        while(pre!=null && next!=null){
            if(next.val<=m){
                pre.next = next.next;
                next.next = temp.next;
                temp.next = next;
                temp = temp.next;
                next = pre.next;
            }else {
               pre = pre.next;
               next = next.next;
            }
        }

        return start.next;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
