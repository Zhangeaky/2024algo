package aleetcode.problem.leetCode283;

import java.util.Arrays;

public class Solution20240319 {

    public void moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }

        int i=0;
        int j=nums.length-1;

        while (i != j) {
            if (nums[i] == 0) {
                moveOneStepForward(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
    }

    // 将数组 第 i+1 到 j 位置的元素往前移动一个位置
    private void moveOneStepForward(int[] nums, int i, int j) {
        int temp = nums[i];
        for (int index=i+1;index<=j;index++) {
            nums[index-1] = nums[index];
        }
        nums[j] = temp;
    }


    public static void main(String[] args) {

        Solution20240319 ss = new Solution20240319();
        int[] input = {0,0,5, 0,0,0,1,0,1,1};
        ss.moveZeroes(input);

        Arrays.stream(input).forEach(System.out::println);

    }
}
