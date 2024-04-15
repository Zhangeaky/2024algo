package aleetcode.problem.leetcode42;

import aleetcode.problem.leetCode160.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution20240416two {


    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        Set<ListNode> sets = new HashSet<>();
        ListNode curr = head;

        // 不成环通过这里退出
        while (curr!=null) {
            //成环一定会退出这里
            if (sets.contains(curr)) {
                return curr;
            } else {
                // 注意这里放置的顺序
                sets.add(curr);
                curr = curr.next;
            }
        }

        return null;
    }
}
