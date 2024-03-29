package aleetcode.problem.leetcode206;

import aleetcode.problem.leetCode160.ListNode;

/**
 * 单向链表反转
 */
public class Solution {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextNode;
        }
        return pre;
    }

    public static void print(ListNode node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.printf("->" + node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        Solution ss = new Solution();
        print(ss.reverseList(head));

    }
}
