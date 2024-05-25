package aleetcode.problem.leetcode112;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/path-sum/">路径总和</a>
 */
@Solution(number = 112)
public class Solution20240326 {

    public static void main(String[] args) {
        List<Integer> aa = new ArrayList<>(200);

        System.out.println(aa.size());
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        return search(targetSum, root);

    }

    private boolean search(int target, TreeNode node) {

        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            target-=node.val;
            if (target==0) {
                return true;
            }
            target+=node.val;
        }

        target-=node.val;
        if (search(target, node.left)) {
            return true;
        }
        if (search(target, node.right)) {
            return true;
        }

        return false;
    }



}
