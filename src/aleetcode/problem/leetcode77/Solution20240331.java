package aleetcode.problem.leetcode77;

import java.util.ArrayList;
import java.util.List;

public class Solution20240331 {

    private List<List<Integer>> resultList;

    private List<Integer> path;

    private int n = 0;

    public List<List<Integer>> combine(int n, int k) {

        resultList = new ArrayList<>();
        if (k > n) {
            return resultList;
        }
        this.n = n;
        path = new ArrayList<>();

        dfs(k, 1);
        return resultList;
    }

    private void dfs(int k, int begin) {

        // 递归终止条件
        if (path.size() == k) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        //单层递归
        for (int i=begin; i<=n; i++) {
            path.add(i);
            dfs(k, i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution20240331 ss = new Solution20240331();
        long start = System.currentTimeMillis();
        List<List<Integer>> combine = ss.combine(4, 4);
        long end = System.currentTimeMillis();
        System.out.println("result:" + combine + "\n" + (end-start));

    }

}
