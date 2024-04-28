package aleetcode.problem.leetcode24;

import aleetcode.problem.leetCode160.ListNode;

/**
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked">两两交换链表中的节点</a>
 */
public class Solution20240428 {

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr = head;
        ListNode pro = head.next;

        int index = 0;

        while (pro!=null) {

            if (index%2 == 0) {
                ListNode temp = pro.next;
                pro.next = curr;
                pre.next = pro;
                curr.next =temp;

                pre = pro;
                pro = curr.next;
            } else {
                pre = pre.next;
                curr = curr.next;
                pro = pro.next;
            }
            index++;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        Solution20240428 ss = new Solution20240428();
        ListNode transfer = ListNode.transfer(new int[]{1, 2, 3, 4, 5, 7});
        ss.swapPairs(transfer).print();

        ss.swapPairs(ListNode.transfer(new int[]{1})).print();


    }

}
