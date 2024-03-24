package aleetcode.problem.leetCode160;

public class Solution20240320 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 异常情况
        if (headA == null || headB == null) {
            return null;
        }

        int sizeOfA = sizeOfLinkedList(headA);
        int sizeOfB = sizeOfLinkedList(headB);

        int diff = Math.abs(sizeOfA - sizeOfB);

        ListNode newStart = null;
        ListNode shortNode = null;
        if (sizeOfA > sizeOfB) {
            newStart = nodeAt(headA, diff);
            shortNode = headB;
        } else if (sizeOfB > sizeOfA){
            newStart = nodeAt(headB, diff);
            shortNode = headA;
        } else if (sizeOfA == sizeOfB) {
            newStart = headA;
            shortNode = headB;
        }


        while (shortNode != newStart) {
            shortNode = shortNode.next;
            newStart = newStart.next;
        }

        return shortNode;

    }

    private int sizeOfLinkedList(ListNode node) {

        ListNode curr = node;
        int sizeOf = 0;

        while (curr != null) {
            curr = curr.next;
            sizeOf++;
        }

        return sizeOf;

    }

    private ListNode nodeAt(ListNode startNode, int step) {

        while (step!=0) {
            startNode = startNode.next;
            step--;
        }
        return startNode;
    }

}
