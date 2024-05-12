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
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode topNode = stack.peek();
            // 左节点 如果不为空则入栈
            if (topNode.left != null) {
                stack.push(topNode.left);
            } else {
                // 左节点为空, 则需要处理当前节点了。
                TreeNode poppedNode = stack.pop();
                resultList.add(poppedNode.val);
                // 并将当前节点的右节点入栈，因为接下来马上处理右节点了。


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
