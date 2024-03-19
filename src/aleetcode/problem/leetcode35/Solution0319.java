package aleetcode.problem.leetcode35;

public class Solution0319 {

    public int searchInsert(int[] nums, int target) {


        return 0;
    }


    private int function(int[] nums, int i, int j, int target) {


        if (i == j) {
            int num = nums[i];
            if (num == target) {
                return i;
            }
            return num > nums[j] ? j+1 : j-1;
        }

        int first = function(nums, i, (i + j) / 2, target);

        int last = function(nums, (i+j)/2+1, j, target);

        if (first == last) {
            return last;
        }

        if (first <= (i+j)/2) {
            return first;
        }

        if (last >= (i+j)/2+1) {
            return last;
        }

    }


}
