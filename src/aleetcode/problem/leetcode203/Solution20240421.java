package aleetcode.problem.leetcode203;

import aleetcode.problem.leetCode160.ListNode;

import java.util.Optional;

public class Solution20240421 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while (curr!=null) {
            if (curr.val == val) {
                pre.next = curr.next;
                curr =curr.next;
                continue;
            }
            pre = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode transfer = ListNode.transfer(new int[]{7,7,7,7});
        Solution20240421 ss = new Solution20240421();
        ListNode node = ss.removeElements(transfer, 7);
        Optional.ofNullable(node).map(ListNode::print);
    }

}
