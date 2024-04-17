package aleetcode.problem.leetcode136;

public class Solution20240417 {

    public int singleNumber(int[] nums) {

        if (nums == null) {
            return 0;
        }
        int target =0;

        for (int i=0; i<nums.length; i++) {

            target^=nums[i];

        }
        return target;
    }

    public static void main(String[] args) {

        Solution20240417 ss = new Solution20240417();
        System.out.println(ss.singleNumber(new int[]{1, 1, 2, 2, 3, 3, 4,4,5}));

    }

}
