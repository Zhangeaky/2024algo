package aleetcode.problem.leetcode21;

import aleetcode.problem.leetCode160.ListNode;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked">合并两个有序链表</a>
 */
public class Solution20240327 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null || list2 == null) {
            return list2 == null ? list1 : list2;
        }

        ListNode one = list1;
        ListNode two = list2;

        while (true) {

            if (one.val < two.val) {

                ListNode temp = one.next;
                one.next = two;


            } else if (one.val == two.val) {

            } else {

            }


        }



        }

}
