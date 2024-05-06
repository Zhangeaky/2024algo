package aleetcode.problem.leetcode25;

import aleetcode.problem.leetCode160.ListNode;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked">
 *     K 个一组翻转链表</a>
 */
public class Solution20240506 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end;
        while ((end=getStep(dummy, k))!=null) {
            reverse(start, end);
            start = end.next;
        }
        return dummy.next;
    }

    private ListNode getStep(ListNode current, int k) {
        ListNode node = current;
        for (int i=0; i<k; i++) {
            if (node == null) {
                return null;
            }
            node = node.next;
        }
        return node;
    }

    private void reverse(ListNode start, ListNode end) {

        ListNode current = null;
        while (current!=end) {

        }

    }
}
