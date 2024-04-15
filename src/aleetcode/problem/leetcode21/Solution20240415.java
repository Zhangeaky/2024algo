package aleetcode.problem.leetcode21;

import aleetcode.problem.leetCode160.ListNode;

public class Solution20240415 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //边界
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre =dummy;
        ListNode next = null;

        while (list1!=null && list2!=null) {
            if (list1.val >= list2.val) {
                next = list2;
                list2 = list2.next;
            } else {
                next = list1;
                list1 = list1.next;
            }
            pre.next = next;
            pre = pre.next;
        }

        pre.next = list1 == null ? list2 : list1;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(4)));

        Solution20240414 ss = new Solution20240414();
        ListNode node = ss.mergeTwoLists(list1, list2);
        node.print();
    }
}
