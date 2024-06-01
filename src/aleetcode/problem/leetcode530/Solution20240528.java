package aleetcode.problem.leetcode530;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/">二叉搜索树的最小</a>
 */
@Solution(number = 530)
public class Solution20240528 {

    private List<Integer> ordered = new ArrayList<>();

    @SolutionMethod("把BST搜索成一个数组 求相邻两个数的差值")
    public int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return 0;
        }
        toList(root);

        if (ordered.isEmpty()) {
            return 0;
        }

        if (ordered.size() < 2) {
            return 0;
        }

        // 因为这里是按照顺序排列的，相邻两个值之间的差一定是最小的。
        int min = Math.abs(ordered.get(1)-ordered.get(0));
        for (int i=2; i<ordered.size(); i++) {
            min = Math.min(min, Math.abs(ordered.get(i-1)-ordered.get(i)));
        }

        return min;
    }

    private void toList(TreeNode root) {

        if (root == null) {
            return;
        }

        toList(root.left);
        ordered.add(root.val);
        toList(root.right);

    }


}
