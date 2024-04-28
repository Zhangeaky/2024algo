package aleetcode.problem.leetcode77;

import java.util.ArrayList;
import java.util.List;

public class Solution20240421 {



    public List<List<Integer>> combine(int n, int k) {

        if (k > n) {
            return null;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(resultList, path, n, k, 1);

        return resultList;
    }

    private void dfs(List<List<Integer>> resultList, List<Integer> path, int n, int k, int beginIndex) {

        // 递归终止条件一
        if (path.size() == k) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // 单层递归
        for (int i=beginIndex; i<=n; i++) {
            if (skip(n, k, path, i)) {
                continue;
            }
            path.add(i);
            // 又是这里犯错了 错写成了 beginIndex
            dfs(resultList, path, n, k, i+1);
            path.remove(path.size()-1);
        }

    }

    private boolean skip(int n, int k, List<Integer> path, int curr) {
        // 仍需投放的个数
        int delta = k - path.size();
        // 至少的起点
        int startPoint = n - delta + 1;
        return startPoint < curr;
    }

    public static void main(String[] args) {
        Solution20240421 ss = new Solution20240421();
        long start = System.currentTimeMillis();
        List<List<Integer>> combine = ss.combine(4, 4);
        long end = System.currentTimeMillis();
        System.out.println("result:" + combine + "\n" + (end-start));
    }

}
