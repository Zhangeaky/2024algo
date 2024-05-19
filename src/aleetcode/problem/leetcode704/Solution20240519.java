package aleetcode.problem.leetcode704;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

@Solution(number = 704)
public class Solution20240519 {

    @SolutionMethod(description = "左闭右闭")
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = nums.length-1;

        while (leftIndex <= rightIndex) {

            int middle = reIndex(leftIndex, rightIndex);
            int middleValue = nums[middle];

            if (target > middleValue) {
                leftIndex = middle+1;
            } else if (target < middleValue) {
                rightIndex = middle-1;
            } else if (target == middleValue) {
                return middle;
            }
        }

        return -1;
    }

    private int reIndex(int left, int right) {
        return (left + right)/2;
    }

    @SolutionMethod(description = "左闭右开")
    public int search_(int[] nums, int target) {

        if (nums == null || nums.length ==0) {
            return -1;
        }

        int leftIndex = 0;

        int rightIndex = nums.length;

        while (leftIndex < rightIndex) {

            int middleIndex = reIndex(leftIndex, rightIndex);
            int middleVale = nums[middleIndex];

            if (target < middleVale) {
                rightIndex = middleIndex;
            } else if (middleVale < target) {
                // 因为左区间是包含的所以需要+1
                leftIndex = middleIndex+1;
            } else {
                return middleIndex;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Solution20240519 ss = new Solution20240519();
        System.out.println(ss.search_(new int[]{-1, 0, 3, 5, 9, 12}, 12));
    }
}
