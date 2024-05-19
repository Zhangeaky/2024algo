package aleetcode.problem.leetcode35;

import aleetcode.problem.instrument.SolutionMethod;

public class Solution0319 {

    public int searchInsert(int[] nums, int target) {
        return function(nums, 0, nums.length-1, target);
    }


    @SolutionMethod(description = "解题失败")
    private int function(int[] nums, int i, int j, int target) {

        // 最大值
        if (nums[j] < target) {
            return j+1;
        }

        if (nums[i] > target) {
            return i;
        }

        if (i == j) {
            int num = nums[i];
            if (num == target) {
                return i;
            }

            if (j == 0) {
                return 0;
            }
            return num > nums[j] ? j+1 : j-1;
        }

        int first = function(nums, i, (i + j) / 2, target);
        if (nums[first] == target) {
            return first;
        }

        int last = function(nums, (i+j)/2+1, j, target);
        if (nums[last] == target) {
            return last;
        }


        if (first < (i+j)/2) {
            return first;
        }

        if (last > (i+j)/2+1) {
            return last;
        }

        return last;
    }

    public static void main(String[] args) {
        Solution0319 ss = new Solution0319();
        int[] input = {1,3,5,6};
        System.out.println(ss.searchInsert(input, 2));
    }


}
