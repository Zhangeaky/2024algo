package aleetcode.problem.leetcode113;

import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/path-sum-ii/description/">路径总和</a>
 */
public class Solution20240325 {

    private static final int ORIGIN = 0;

    private int target;

    private List<List<Integer>> resultList;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null) {
            return resultList;
        }

        target = targetSum;
        List<Integer> path = new ArrayList<>();

        dfs(path, root);

        return  resultList;
    }

    private void dfs(List<Integer> path, TreeNode root) {

        // 递归终止
        if (root == null) {
            if (target == sumList(path)) {
                resultList.add(new ArrayList<>(path));
            }
            return;
        }

        path.add(root.val);
        dfs(path, root.left);
        dfs(path, root.right);
        path.remove(path.size()-1);
    }

    private int sumList(List<Integer> input) {
        if (input.size() == 0) {
            return 0;
        }
        return input.stream().reduce(ORIGIN, Integer::sum);
    }

    public static void main(String[] args) {

        Solution20240325 ss = new Solution20240325();
        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println(ss.sumList(list));

        List<Integer> ggg = new ArrayList<>(16);
        System.out.println(ggg.size());


    }
}
