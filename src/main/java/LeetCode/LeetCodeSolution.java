package LeetCode;

public class LeetCodeSolution {

    /**
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;

        ListNode next = head.next;
        ListNode cur = head;

        while(next!=null){
            if(next.val == cur.val){
                next = next.next;
                cur.next = next;
            } else {
               cur = next;
               next = cur.next;
            }
        }

        return head;
    }


    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     *      执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     *      内存消耗：39.4 MB, 在所有 Java 提交中击败了5.55%的用户
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;

        ListNode min = null;
        ListNode max = null;
        ListNode cur = head;

        while (max==null || min==null){
            if(cur == null)
                break;
            if(cur.val<x)
                min = cur;
            if(cur.val>=x)
                max = cur;
            cur = cur.next;
        }

        if(max == null || min==null)
            return head;

        if(min.next != max){
            max.next = cur;
            min.next = head;
            head = min;
        }

        while (cur!=null) {
            if(cur.val>=x){
                max = cur;
            } else{
                max.next = cur.next;
                cur.next = min.next;
                min.next = cur;
                min = cur;
            }
            cur = max.next;
        }
        return head;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
