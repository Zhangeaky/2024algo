package aleetcode.problem.leetcode541;

/**
 * <a href="https://leetcode.cn/problems/reverse-string-ii/description/">反转字符串II</a>
 */
public class Solution20240422 {


    public String reverseStr(String s, int k) {

        if (s==null || s.length()<=1 || k==0) {
            return s;
        }

        char[] chars = new char[s.length()];

        s.getChars(0, s.length(), chars, 0);

        int length = s.length();

        int groupNum = length % 2 == 0 ? (length / (2 * k)) : (length / (2 * k)) +1;

        if ((length/(2*k))==0) {
            groupNum = 1;
        }

        for (int i=0; i<=groupNum; i++) {
            int start = 2*(i)*k;
            int end = i == groupNum ? chars.length-1 : start +(k-1) ;
            exchange(chars, start, end);
        }

        return new String(chars);
    }

    private void exchange(char[] str, int start, int end) {

        while (start < end) {
            if (str[start] == str[end]) {
                start++;
                end--;
                continue;
            }
            char c = str[start];
            str[start] = str[end];
            str[end] = c;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        Solution20240422 ss = new Solution20240422();
        System.out.println(ss.reverseStr(s, 3));
        System.out.println(8%2);

    }


}
