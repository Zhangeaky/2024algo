package aleetcode.problem.leetcode141;


import aleetcode.problem.leetCode160.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution20240326 {

    // 比较垃圾的做法
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        Set<ListNode> container = new HashSet<>();
        while (head!=null) {
            if (container.contains(head)) {
                return true;
            }
            container.add(head);
            head = head.next;
        }

        return false;
    }


    // 快慢指针
    public boolean hasCycle2(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (slow!=null&&fast!=null) {
            slow = slow.next;
            fast = fast.next;
            if (fast!=null) {
                fast=fast.next;
            } else {
                return false;
            }

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
