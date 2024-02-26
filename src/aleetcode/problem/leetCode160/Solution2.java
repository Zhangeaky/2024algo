package aleetcode.problem.leetCode160;


public class Solution2 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }

        ListNode startOfA = headA;
        ListNode startOfB = headB;

        while (headA != headB) {

            // 未走到共同点 且 A已经走到终点 将起点设置到B链表的起点
            if (headA == null) {
                headA = startOfB;
            } else {
                headA = headA.next;
            }

            // 未走到共同点 且 A已经走到终点 将起点设置到B链表的起点
            if (headB == null) {
                headB = startOfA;
            } else {
                headB = headB.next;
            }
        }

        return headA;
    }
}
