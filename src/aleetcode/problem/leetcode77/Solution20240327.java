package aleetcode.problem.leetcode77;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/description/">组合</a>
 */
public class Solution20240327 {


    private List<List<Integer>> resultList;

    private List<Integer> path;


    public List<List<Integer>> combine(int n, int k) {

        resultList = new ArrayList<>();
        if (n==0 || k==0 || n < k) {
            return resultList;
        }

        path = new ArrayList<>();
        process(n, k, 1);

        return resultList;

    }

    private void process(int value, int sizeOf, int startIndex) {

        // 递归终止条件1
        if (path.size() == sizeOf) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // 单层递归
        for (int i=startIndex; i<=value; i++) {
            path.add(i);
            // 重点理解这里为什么 第三个参数是 i+1 而不是 startIndex + 1
            process(value, sizeOf, i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution20240327 ss = new Solution20240327();
        System.out.println(ss.combine(4, 2));
    }



}
