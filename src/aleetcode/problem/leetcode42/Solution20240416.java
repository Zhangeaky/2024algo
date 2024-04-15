package aleetcode.problem.leetcode42;

import aleetcode.problem.leetCode160.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  <a href="https://leetcode.cn/problems/linked-list-cycle-ii/submissions/523955988/?envType=study-plan-v2&envId=top-100-liked">环形链表II</a>
 */
public class Solution20240416 {

    // 这种解封耗时只击败了2.36%
    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        Map<ListNode, Integer> nodeCounterMap = new HashMap<>();
        ListNode curr = head;

        // 如果成环 这里就出不来了
        while (!Integer.valueOf(2).equals(nodeCounterMap.get(curr))) {

            if (curr == null) {
                break;
            }

            if (nodeCounterMap.get(curr) == 3) {
                return head;
            }

            Integer integer = nodeCounterMap.get(curr);
            if (integer == null) {
                nodeCounterMap.put(curr, 0);
            } else {
                nodeCounterMap.put(curr, ++integer);
            }
            curr = curr.next;
        }

        // 链表没有环
//        if (curr == null) {
//            return null;
//        } else {
//            // 链表有环 且
//            return curr;
//        }
        return curr;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode four_ = new ListNode(-4);

        one.next = two;
        two.next = zero;
        zero.next = four_;
        four_.next = two;

        Solution20240416 ss = new Solution20240416();
        System.out.println(ss.detectCycle(one));


    }
}
