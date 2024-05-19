package aleetcode.problem.leetcode35;


import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

@Solution(number = 35)
public class Solution202040519 {

    @SolutionMethod(description = "")
    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length ==0) {
            return -1;
        }

        int indexLeft = 0;
        int indexRight = nums.length-1;
        int lastMiddle = 0;

        while (indexLeft <= indexRight) {
            lastMiddle = (indexLeft + indexRight)/2;
            int middle = nums[lastMiddle];

            if (target < middle) {
                indexRight = lastMiddle-1;
            } else if (middle < target) {
                indexLeft = lastMiddle +1;
            } else {
                return lastMiddle;
            }
        }

        return target <= nums[lastMiddle] ? lastMiddle : lastMiddle+1;
    }

    public static void main(String[] args) {
        Solution202040519 ss = new Solution202040519();
        System.out.println(ss.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }

}
