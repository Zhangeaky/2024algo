package aleetcode.problem.leetcode226;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * Description of the method.
 *
 * @param paramName Description of the parameter
 * @return Description of the return value
 */
@Solution(number = 226)
public class Solution20240517 {

    @SolutionMethod
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        exchange(root.left, root.right);


        return root;
    }

    private void exchange(TreeNode left, TreeNode right) {



        exchange(left.left, right.right);


        exchange(left.right, right.left);



    }


}
