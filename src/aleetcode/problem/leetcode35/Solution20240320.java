package aleetcode.problem.leetcode35;

import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked">搜索插入位置</a>
 */
public class Solution20240320 {

    @SolutionMethod(description = "解题失败")
    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 初始化左右边界
        int left = 0;
        int right = nums.length-1;
        int temp;
        int mid;

        while (left <= right) {
            mid = left + (right - left)/2;
            if (nums[mid] == target) {
                temp = mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid +1;
            }
        }

        return 0;
    }
}
