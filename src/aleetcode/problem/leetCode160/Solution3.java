package aleetcode.problem.leetCode160;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }

        Set<ListNode> listOfA = putIntoSet(headA);

        while (headB !=null) {
            if (listOfA.contains(headB)) {
                break;
            }
            headB = headB.next;
        }

        return headB;
    }

    private Set<ListNode> putIntoSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        return set;
    }
}
