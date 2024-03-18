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
        return head;
    }
}
