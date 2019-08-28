package LeetCode.链表;

import LeetCode.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。
 * 将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int flag = 0;
        int i;
        int j;
        int temp;
        while(!stack1.isEmpty() || !stack2.isEmpty() || flag==1){
            if(stack1.isEmpty())
                i=0;
            else
                i=stack1.pop();

            if(stack2.isEmpty())
                j=0;
            else
                j=stack2.pop();

            temp = i+j+flag;
            ListNode newNode = new ListNode(temp%10);
            newNode.next = result.next;
            result.next = newNode;
            flag = temp/10;
        }

        return result.next;
    }

    /**|
     * 5ms实例，实际执行10ms
     * @param node1
     * @param node2
     * @return
     */
    public ListNode addTwoNumbers_5ms(ListNode node1, ListNode node2) {
        int node1Length = calListNodeLength(node1);
        int node2Length = calListNodeLength(node2);

        ListNode head = new ListNode(-1);
        ListNode node = head;
        ListNode tmpNode1 = (node1Length >= node2Length) ? node1 : node2;
        ListNode tmpNode2 = (node1Length < node2Length) ? node1 : node2;
        int lengthDiff = Math.abs(node1Length - node2Length);

        for (int i = 0; i < lengthDiff; i++) {
            node.next = new ListNode(tmpNode1.val);
            tmpNode1 = tmpNode1.next;
            node = node.next;
        }

        while (tmpNode1 != null && tmpNode2 != null) {
            int value = tmpNode1.val + tmpNode2.val;
            tmpNode1 = tmpNode1.next;
            tmpNode2 = tmpNode2.next;
            node = node.next = new ListNode(value);
        }

        // 存储进位值
        int num = convertInt(head.next);
        while (num != 0) {
            ListNode tmp = new ListNode(num % 10);
            tmp.next = head.next;
            head.next = tmp;
            num /= 10;
        }
        return head.next;
    }

    public int calListNodeLength(ListNode data) {
        int count = 0;
        while (data != null) {
            data = data.next;
            count ++;
        }
        return count;
    }

    public int convertInt(ListNode data) {
        if (data != null) {
            int num = data.val + convertInt(data.next);
            data.val = num % 10;
            return num / 10;
        }
        return 0;
    }
}
