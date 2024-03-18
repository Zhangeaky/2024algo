package aleetcode.problem.leetcode20;

import java.time.temporal.ChronoField;
import java.util.*;

public class Solution {

    private static Map<Character, Character> map = new HashMap<>();


    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    private static Stack<Character> stack = new Stack<>();


    public boolean isValid(String s) {

        if (s==null || s.equals("")) {
            return false;
        }

        for(int i=0; i<=s.length()-1; i++) {
            char c = s.charAt(i);

            if (map.containsValue(c)) {
                stack.push(c);
            }

            if (map.containsKey(c)) {
                if (map.get(c).equals(stack.peek())) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        System.out.println(ss.isValid("()[]{)}"));
    }
}
