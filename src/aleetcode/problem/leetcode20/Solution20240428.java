package aleetcode.problem.leetcode20;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked">有效的括号</a>
 */
public class Solution20240428 {
    // 核心点 就是 push进去的 一定和上一个是相反的
    // 左边无脑push 右边如果push的时候，如果stack为空非法
    public boolean isValid(String s) {

        if (s == null || (s.length()%2) != 0 ) {
            return false;
        }

        Map<Character, Character> mapper = new HashMap<>();
        mapper.put('[', ']');
        mapper.put('(', ')');
        mapper.put('{', '}');

        // 这里需要抽象，而不是特判  }()  ()}{ 这两种情况是一样的
        // 抽象的逻辑是，如果stack空了 然后当前元素是右边则非法
//        if (!mapper.containsKey(s.charAt(0))) {
//            return false;
//        }

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);
            if (mapper.containsKey(c)) {
                stack.push(c);
                // 这个不加也可以 因为 两个if条件式对立的
                continue;
            }

            if (mapper.containsValue(c)) {
                if (stack.empty()) {
                    return false;
                }

                if (!mapper.get(stack.peek()).equals(c)) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Solution20240428 ss = new Solution20240428();
        System.out.println(ss.isValid("(){}}{"));
    }
}
