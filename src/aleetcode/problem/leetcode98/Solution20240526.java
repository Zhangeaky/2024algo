package aleetcode.problem.leetcode98;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked">
 *     验证二叉搜索树</a>
 */
@Solution(number = 98)
public class Solution20240526 {

    @SolutionMethod
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        // 中序遍历之后是有顺序的
        List<Integer> resultList = new ArrayList<>();
        dfs(root, resultList);

        for (int i=0; i<resultList.size(); i++) {
            if (i != 0) {
                if (!(resultList.get(i-1) < resultList.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(TreeNode node, List<Integer> resultList) {

        if (node == null) {
            return;
        }

        dfs(node.left, resultList);
        resultList.add(node.val);
        dfs(node.right, resultList);

    }


}
