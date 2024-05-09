package aleetcode.problem.leetcode337;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/house-robber-iii/">打家劫舍III</a>
 */

@Solution(number = 337)
public class Solution20240509 {


    @SolutionMethod
    public int rob(TreeNode root) {
        int[] dp = robUnit(root);
        return Math.max(dp[0], dp[1]);
    }

    /**
     * 递归函数
     * @param root 树节点
     * @return 每个节点对应的dp数组 dp[0]表示不偷当前节点的最大值,dp[1]表示偷当前节点的最大值。
     */
    private int[] robUnit(TreeNode root) {

        // 递归终止条件 当前为叶子节点
        if (root == null) {
            return new int[2];
        }

        // 后序遍历
        int[] dpOfLeft = robUnit(root.left);
        int[] depOfRight = robUnit(root.right);

        // 偷当前节点, 他的子节点就不能偷了, 所以只能去dp数组的0位
        int valueOfRobCurrent = root.val + dpOfLeft[0] + depOfRight[0];

        // 不偷当前节点, 他的子节点可偷可不偷
        int valueOfNotRobCurrent =
                Math.max(dpOfLeft[0], dpOfLeft[1]) +
                Math.max(depOfRight[0], depOfRight[1]);

        return new int[]{valueOfNotRobCurrent, valueOfRobCurrent};
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(3,
                new TreeNode(4, new TreeNode(1, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(5, new TreeNode(1, null, null), null));

        Solution20240509 solution20240509 = new Solution20240509();
        System.out.println(solution20240509.rob(node));


    }
}
