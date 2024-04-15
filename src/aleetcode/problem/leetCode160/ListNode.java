package aleetcode.problem.leetCode160;

public class ListNode {

    // TODO: 2024/4/14 构建数组链表的gongneng

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

    public String print() {
        ListNode curr = this;
        StringBuilder toString = new StringBuilder();
        while (curr!=null) {
            toString.append(curr.val).append(" ");
            curr = curr.next;
        }
        toString.append("===");
        System.out.println(toString.toString());
        return toString.toString();
    }

    @Override
    public String toString() {
        return "value:" + val + ";";
    }
}
