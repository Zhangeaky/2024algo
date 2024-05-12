package aleetcode.problem.leetcode94;


import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Solution(number = 94)
public class Solution20240512 {

    @SolutionMethod(description = "使用迭代法")
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();
        // 使用栈来记录节点的访问顺序
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        // 循环退出的条件为什么是这个 要看下
        while (current!=null || !stack.isEmpty()) {

            // 左节点不为空，则一直遍历下去
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                //左节点为空 则开始处理当前节点。栈顶的就是当前节点
                current = stack.pop();
                // 处理当前节点
                resultList.add(current.val);
                // 处理右节点
                current = current.right;
            }

        }

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6));
        Solution20240512 ss = new Solution20240512();
        System.out.println(ss.inorderTraversal(root));
    }
}
