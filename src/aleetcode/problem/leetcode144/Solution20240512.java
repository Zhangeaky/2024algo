package aleetcode.problem.leetcode144;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Solution(number = 144)
public class Solution20240512 {

    @SolutionMethod(description = "使用循环")
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top == null) {
                continue;
            }
            resultList.add(top.val);

            stack.push(top.right);
            stack.push(top.left);
        }

        return resultList;
    }
}
