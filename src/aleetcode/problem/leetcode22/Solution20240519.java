package aleetcode.problem.leetcode22;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

@Solution
public class Solution20240519 {

    @SolutionMethod(description = "现根据自己的思路:" +
            "用回溯排列出所有的括号序列")
    public List<String> generateParenthesis(int n) {

        List<String> resultList = new ArrayList<>();
        char[] input = new char[]{'(', ')'};
        List<Character> path = new ArrayList<>();

        dfs(input, path, resultList, n);


        return resultList;
    }

    private void dfs(char[] input, List<Character> path, List<String> resultList, int n) {

        // 递归终止条件
        if (path.size() == 2*n) {
            if (isValid(path)) {
                resultList.add(toString(path));
            }
            return;
        }

        for (int i=0; i<input.length; i++) {
            path.add(input[i]);

            dfs(input, path, resultList, n);

            path.remove(path.size()-1);
        }
    }

    private boolean isValid(List<Character> path) {

        Stack<Character> stack = new Stack<>();
        for (Character character : path) {

            if (stack.isEmpty() && character.equals(')')) {
                return false;
            }

            if (character.equals('(')) {
                stack.push(character);
            }

            if (character.equals(')')) {
                if (!stack.peek().equals('(')) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private String toString(List<Character> path) {
        return path.stream().map(String::valueOf).collect(Collectors.joining());
    }


    @SolutionMethod(description = "现根据自己的思路:" +
            "用回溯排列出所有的括号序列" +
    "回溯剪枝")
    public List<String> generateParenthesis_(int n) {

        return null;
    }



    public static void main(String[] args) {
        Solution20240519 ss = new Solution20240519();
        System.out.println(ss.generateParenthesis(3));
    }
}
