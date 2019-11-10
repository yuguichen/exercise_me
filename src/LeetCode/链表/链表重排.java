package LeetCode.链表;

import LeetCode.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class 链表重排 {
    public void reorderList(ListNode head) {
        if(head == null)
            return ;

        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode before = head;
        ListNode after = reverse(slow.next);
        slow.next = null;

        while(after!=null){
            ListNode temp = after;
            after = after.next;
            temp.next = before.next;
            before.next = temp;
            before = before.next.next;
        }
    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next==null)
            return head;

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode node = head.next;

        while(node!=null){
            head.next = node.next;
            node.next = newHead.next;
            newHead.next = node;
            node = head.next;
        }

        return newHead.next;
    }
}
