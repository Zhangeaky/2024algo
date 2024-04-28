package aleetcode.problem.leetcode216;

import java.util.ArrayList;
import java.util.List;
/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii/description/">组合总和III</a>
 */
public class Solution20240422 {

    private List<List<Integer>> resultList = new ArrayList<>();

    private List<Integer> path;

    private int target;

    private int curr;

    private int k;

    public List<List<Integer>> combinationSum3(int k, int n) {

        if (k > n) {
            return resultList;
        }

        path = new ArrayList<>();
        target = n;
        curr = n;
        this.k = k;

        dfs(1);

        return resultList;
    }

    private void dfs(int beginIndex) {

        // 递归终止条件1. 组合之和已经到达目标
        if (path.size() == k && curr == 0) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // 单层递归
        for (int i=beginIndex; i<=9; i++) {

            if (skip(i)) {
                continue;
            }

            path.add(i);
            curr = curr-i;
            dfs(i+1);
            path.remove(path.size()-1);
            curr = curr+i;
        }
    }


    /**
     * 1. 从当前时刻再遍历 已经超过了k个数了
     * 1. 从当前时刻再遍历 已经不够了k个数了
     * 3. 从当前时刻再遍历 已经超过总和n了
     * @return 是否剪枝
     */
    private boolean skip(int index) {

        if (curr - index < 0) {

            return true;
        }

        if (this.path.size() >= k) {
            return true;
        }

        int delta = 9 - path.size() + 1;
        if (index > delta) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        Solution20240422 ss = new Solution20240422();
        System.out.println(ss.combinationSum3(3, 9));
    }
}
