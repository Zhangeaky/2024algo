package aleetcode.problem.leetCode160;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    /**
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //
        if (headA == null || headB == null) {
            return null;
        }

        //
        if (headA == headB) {
            return headA;
        }

        int countOfA = count(headA);
        int countOfB = count(headB);

        int delta = Math.abs( countOfA - countOfB );
        ListNode jumpingList = countOfA > countOfB ? headA : headB;
        ListNode nonJumpingList = countOfA > countOfB ? headB : headA;

        for (int index=0; index<delta; index++) {
            jumpingList = jumpingList.next;
        }


        while ( jumpingList != nonJumpingList) {
            jumpingList = jumpingList.next;
            nonJumpingList = nonJumpingList.next;
        }

        return jumpingList;
    }

    // 计算链表的长度
    private int count(ListNode node) {
        int count = 0;
        ListNode curr = node;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }
}