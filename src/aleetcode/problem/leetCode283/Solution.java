package aleetcode.problem.leetCode283;

import java.util.Arrays;

public class Solution {


    public void moveZeroes(int[] nums) {

        if (nums == null) {
            return;
        }

        int head = 0; // 头指针
        int tail = nums.length-1; // 尾指针


        while (tail != head) {

            if (nums[head] == 0) {
                for (int i=head+1; i<=tail; i++) {
                    nums[i-1]=nums[i];
                }
                nums[tail]=0;
                tail--;
            } else {
                head++;
            }
        }

    }

    public static void main(String[] args) {
        Solution ss = new Solution();
        int[] nums = { 0, 0, 0, 0, 0,5};
        ss.moveZeroes(nums);
        Arrays.stream(nums).forEach(value -> System.out.printf(","+value));
    }
}
