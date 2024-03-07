package aleetcode.problem.leetcode78;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  [1, 2, 3, 4]
 *
 *  [1] [2] [3] [4]
 *  [1, 2]
 *
 */
public class Solution1 {

    private List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        if (nums == null) {
            return resultList;
        }

        dfs(0, new ArrayList<>(), nums);
        return resultList;
    }

    /**
     * @param count 当前子集元素个数
     * @param nums 当前解
     * @param nums 给定数组
     *             [1] [1,2] [1, 2, 3] [1, 3]
     */
    private void dfs(int count, List<Integer> ele, int[] nums) {

        if (count > nums.length) {
            return;
        }

        for (int i=0; i<nums.length; i++) {
            // 选择
            if (!ele.contains(nums[i])) {
                ele.add(nums[i]);
                resultList.add(new ArrayList<>(ele));
            } else {
                continue;
            }

            dfs(count++, ele, nums);
             // 后撤
            ele.remove(ele.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution1 ss = new Solution1();
        ss.dfs(0, new ArrayList<>(), new int[]{1, 2, 3});
        System.out.println(ss.resultList);
    }

}
