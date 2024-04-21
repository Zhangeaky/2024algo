package aleetcode.problem.leetcode39;

import java.util.ArrayList;
import java.util.List;

public class Solution20240418 {

    private List<Integer>       path;

    private List<List<Integer>> resultList = new ArrayList<>();

    private int                 target;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || target <0) {
            return resultList;
        }
        this.path = new ArrayList<>();
        this.target = target;
        dfs(candidates, 0);
        return resultList;
    }

    private void dfs(int[] input, int beginIndex) {

        // 递归终止条件1
        if (target == 0) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // "满了 但是没有凑到target" 可以重复使用哦所以不要有这个条件
//        if (path.size() == input.length) {
//            return;
//        }
        if (target < 0) {
            return;
        }

        for (int i=beginIndex; i<input.length; i++) {
            path.add(input[i]);
            target-=input[i];
            dfs(input, i);
            target+=input[i];
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution20240418 ss = new Solution20240418();
        System.out.println(ss.combinationSum(new int[]{2,3,5}, 8));
    }
}
