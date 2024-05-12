package aleetcode.problem.leetcode145;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Solution(number = 145)
public class Solution20240512 {

    @SolutionMethod(description = "使用迭代法")
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);


        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top==null) {
                continue;
            }
            resultList.add(top.val);

            stack.push(top.left);
            stack.push(top.right);
        }
        Collections.reverse(resultList);
        return resultList;
    }

}
