package aleetcode.problem.leetcode19;

import aleetcode.problem.leetCode160.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/?envType=study-plan-v2&envId=top-100-liked">
 *     删除链表的第n个节点
 * </a>
 */
public class Solution20240416 {


    //3.90% 运行时间
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        Map<Integer, ListNode> indexMap = new HashMap<>();
        indexMap.put(0, dummy);

        // 遍历到最后一个节点
        int index = 1;
        while (curr != null) {
            indexMap.put(index++, curr);
            curr = curr.next;
        }

        if (n > indexMap.size()) {
            return null;
        }

        ListNode preTargetIndex =  indexMap.get(indexMap.size() - n -1);
        preTargetIndex.next = indexMap.get(indexMap.size() - n+1);
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        Solution20240416 ss = new Solution20240416();
        ListNode node = ss.removeNthFromEnd(input, 2);
        node.print();

        node = ss.removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
        node.print();

        node = ss.removeNthFromEnd(new ListNode(1), 1);



    }

}
