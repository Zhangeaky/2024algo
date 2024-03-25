package aleetcode.problem.leetcode113;

import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/path-sum-ii/description/">路径总和</a>
 */
public class Solution20240325 {

    private int target;

    private List<List<Integer>> resultList;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }

        target = targetSum;
        List<Integer> path = new ArrayList<>();

        dfs(path, root);

        return  resultList;
    }

    private void dfs(List<Integer> path, TreeNode root) {

        // 递归终止 空节点
        if (root == null) {
            return;
        }

        // 递归终止 椰子节点
        if (root.right == null & root.left == null) {
            target-=root.val;
            path.add(root.val);
            if (target == 0) {
                resultList.add(new ArrayList<>(path));
            }
            target+=root.val;
            path.remove(path.size()-1);
            return;
        }

        target-=root.val;
        path.add(root.val);
        dfs(path, root.left);

        dfs(path, root.right);
        path.remove(path.size()-1);
    }



    public static void main(String[] args) {

        Solution20240325 ss = new Solution20240325();
        List<Integer> list = Arrays.asList(1,2,3);

        List<Integer> ggg = new ArrayList<>(16);
        System.out.println(ggg.size());


    }
}
