package aleetcode.problem.leetcode234;

import aleetcode.problem.leetCode160.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">回文链表</a>
 */
public class Solution234 {

    private List<Integer> container = new ArrayList<>();

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        while (head!=null) {
            container.add(head.val);
            head = head.next;
        }

        int headRef = 0;
        int tailRef = container.size() - 1;

        while (headRef <= tailRef) {
            if (container.get(headRef).equals(container.get(tailRef))) {
                headRef ++;
                tailRef --;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
