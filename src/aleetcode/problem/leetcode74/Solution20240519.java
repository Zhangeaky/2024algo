package aleetcode.problem.leetcode74;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
@Solution(number = 74)
public class Solution20240519 {

    @SolutionMethod(description = "自己的想法：" + "效果挺差 只1%超过" +
            "将矩阵的每一行的第一列拿出来组成一个新的数组，进行二分计算，得到数字在第几行。" +
            "然后再目标行进行二分计算")
    public boolean searchMatrix(int[][] matrix, int target) {

        if (target < matrix[0][0] || target > matrix[matrix.length-1][matrix[0].length-1]) {
            return false;
        }

        int[] firstArray = new int[matrix.length];

        for (int i=0; i< matrix.length; i++) {
            firstArray[i] = matrix[i][0];
        }

        int targetRow = getTargetIndex(firstArray, target);
        System.out.println("targetRow:" + targetRow);
        if (targetRow == -1) {
            return false;
        }
        int targetCol = getTargetIndex(matrix[targetRow], target);
        System.out.println("targetCol:" + targetCol);
        return  matrix[targetRow][targetCol] == target;
    }

    private int getTargetIndex(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int middleIndex = (left+right)/2;

        while (left<=right) {
            middleIndex = (left + right)/2;
            int middleVale = nums[middleIndex];

            if (target < middleVale) {
                right = middleIndex-1;
            } else if (middleVale < target) {
                left = middleIndex +1;
            } else {
                return middleIndex;
            }
        }

        if (target <nums[middleIndex]) {
            return middleIndex-1;
        }

        return middleIndex;
    }

    public static void main(String[] args) {
        Solution20240519 ss = new Solution20240519();
        System.out.println(
                ss.searchMatrix(new int[][]{
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60}
                }, 30)
        );
    }
}
