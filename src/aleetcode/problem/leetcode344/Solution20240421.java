package aleetcode.problem.leetcode344;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/description/">反转字符串</a>
 */
public class Solution20240421 {

    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int head = 0;
        int tail = s.length-1;
        while (head < tail) {
            if (s[head] == s[tail]) {
                head++;
                tail--;
                continue;
            }
            char atHead = s[head];
            s[head] = s[tail];
            s[tail] = atHead;
            head++;
            tail--;
        }
    }

    public static void main(String[] args) {
        Solution20240421 ss = new Solution20240421();
        char[] chars = {'a', 'b'};
        ss.reverseString(chars);
    }
}
