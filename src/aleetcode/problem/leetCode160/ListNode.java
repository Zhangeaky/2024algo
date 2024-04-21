package aleetcode.problem.leetCode160;

public class ListNode {

    // TODO: 2024/4/14 构建数组链表的gongneng
    public static ListNode transfer(int[] arr) {
        if (arr == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = null;
        for (int i : arr) {
            if (dummy.next == null) {
                dummy.next = new ListNode(i);
                curr = dummy.next;
                continue;
            }
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode transfer = transfer(new int[]{1, 2, 3});
        System.out.println(transfer);

    }


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
            toString.append(curr.val).append("->");
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
