package aleetcode.problem.leetCode160;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
      val = x;
      next = null;
    }
    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public void print() {
        ListNode curr = this;
        while (curr!=null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println("===");
    }
}
