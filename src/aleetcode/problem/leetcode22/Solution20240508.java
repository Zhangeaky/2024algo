package aleetcode.problem.leetcode22;

import java.util.*;
import java.util.stream.Collectors;

import aleetcode.problem.instrument.Solution;
import org.w3c.dom.ls.LSInput;

/**
 * <a href="https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked">括号生成</a>
 */
@Solution(number = 22)
public class Solution20240508 {


    private Stack<String> validator = new Stack<>();

    private List<String> path = new ArrayList<>();

    private List<String> resultList = new ArrayList<>();

    private Map<String, String> mapper = new HashMap<>();



    public List<String> generateParenthesis(int n) {
        mapper.put(")", "(");

        String[] given = new String[]{"(", ")"};
        dfs(given, n);

        List<String> collect = resultList.stream().filter(this::validate).collect(Collectors.toList());
        List<String> res = new ArrayList<>();

        for (String s : collect) {
            StringBuilder sb  = new StringBuilder(s);
            for (int i=0; i<s.length(); i++) {
                sb.append(mapper.get(String.valueOf(s.charAt(i))));
            }
            res.add(sb.toString());
        }
        return res;
    }

    private boolean validate(String input) {
        return false;
    }

    private void dfs(String[] given, int n) {

        // 递归终止条件
        if (path.size() == n) {
            resultList.add(String.join("", path));
            return;
        }

        for (int i=0; i<given.length; i++) {
            path.add(given[i]);
            dfs(given, n);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution20240508 ss = new Solution20240508();
        System.out.println(ss.generateParenthesis(3));
    }


}
