package aleetcode.problem.leetcode203;

import aleetcode.problem.leetCode160.ListNode;

public class Solution20240411 {


    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        ListNode pre = dummy;

        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
                curr = curr.next;
                continue;
            }
            pre = pre.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))));
        head.print();
        Solution20240411 ss = new Solution20240411();
        ListNode node = ss.removeElements(head, 1);
        node.print();

    }
}
