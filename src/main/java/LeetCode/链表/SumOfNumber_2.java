package LeetCode.链表;

import LeetCode.ListNode;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class SumOfNumber_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = new ListNode(0);
        ListNode cur = sumNode;
        int l1num;
        int l2num;
        int sum;
        int shi = 0;

        while(l1 != null || l2 != null || shi != 0){
            if(cur.next == null)
                cur.next = new ListNode(0);
            cur = cur.next;
            l1num = l1 != null? l1.val:0;
            l2num = l2 != null? l2.val:0;
            sum = l1num+l2num+shi;
            cur.val = sum % 10;
            shi = sum>=10 ? 1:0;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }
        return sumNode.next;
    }
}
