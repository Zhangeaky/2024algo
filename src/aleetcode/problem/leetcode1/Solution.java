package aleetcode.problem.leetcode1;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked">两数之和</a>
 */
public class Solution {

    // 引入一个hashMap key是target-curr value是数组下标
    public int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return null;
        }

        Map<Integer, Integer> container = new HashMap<>();
        int[] resultArray = new int[2];


        for (int i=0; i<nums.length; i++) {
            container.put(target-nums[i], i);
        }

        for (int i=nums.length-1; i>0; i--) {
            Integer index = container.get(nums[i]);
            if (index != null) {
                resultArray[0] = i;
                resultArray[1] = index;
            }
        }

        return resultArray;

    }
}
