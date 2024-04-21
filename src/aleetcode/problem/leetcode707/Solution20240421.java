package aleetcode.problem.leetcode707;

import aleetcode.problem.leetCode160.ListNode;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/design-linked-list/">设计链表</a>
 */
public class Solution20240421 {

    static class MyLinkedList {

        private ListNode head;

        private ListNode tail;

        private int      size;


        public MyLinkedList() {
        }

        public int get(int index) {

            if (head == null || index < 0 || index >= size) {
                throw new RuntimeException("Index Out of boundary.");
            }

            if (index == 0) {
                return head.val;
            }

            if (index == size-1) {
                return tail.val;
            }

            ListNode curr = head;
            while (index!=0) {
                index--;
                curr = curr.next;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
            size++;

            if (tail == null) {
                tail = head;
            }
        }

        public void addAtTail(int val) {
            ListNode curr = new ListNode(val);
            size++;
            if (tail == null) {
                head = curr;
                tail = head;
            }
            tail.next = curr;
            tail = curr;
        }

        public void addAtIndex(int index, int val) {

            if (index > size || index < 0) {
                throw new RuntimeException("Index Out of boundary.");
            }

            ListNode add = new ListNode(val);
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = dummy;

            int newIndex = index;
            while (newIndex!=0) {
                newIndex--;
                curr = curr.next;
            }

            ListNode originNext = curr.next;
            curr.next = add;
            add.next = originNext;

            if (index == 0) {
                head = add;
            }

            if (index == size) {
                tail = add;
            }

            size++;
        }

        public void deleteAtIndex(int index) {

            if (index > size || index < 0) {
                throw new RuntimeException("Index Out of boundary.");
            }

            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = head;
            ListNode pre = dummy;

            int newIndex = index;
            while (newIndex!=0) {
                newIndex--;
                pre = curr;
                curr = curr.next;
            }

            pre.next = curr.next;

            if (index == 0) {
                head = dummy.next;
            }

            if (index == size-1) {
                tail = pre;
            }

            size--;
        }


        // 非官方要求方法 用于测试
        public ListNode getHead() {
            return head;
        }
    }

    public static void main(String[] args) {

        MyLinkedList ss = new MyLinkedList();
        ss.addAtHead(2);
        ss.addAtHead(1);
        System.out.println();


    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
