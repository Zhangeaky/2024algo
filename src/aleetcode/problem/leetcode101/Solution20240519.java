package aleetcode.problem.leetcode101;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

@Solution(number = 101)
public class Solution20240519 {

    @SolutionMethod
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if ( (left !=null && right==null) || (left ==null && right!=null)) {
            return false;
        }

        //对自己先判断
        if (left.val != right.val) {
            return false;
        }

        boolean outer = process(left.left, right.right);

        boolean inner = process(left.right, right.left);

        return outer && inner;

    }

}
