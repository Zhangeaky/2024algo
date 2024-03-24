package aleetcode.problem.leetcode704;

public class Solution20240320 {

    public int search(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }
        // 初始化 左右界
        int left = 0;
        int right = nums.length-1;
        int mid;

        // 重点需要理解 left <= right 这种写法是什么意思？
        while (left <= right) {
            mid = giveMid(left, right);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }

        return -1;

    }

    // 防止正数相加溢出
    int giveMid(int a, int b) {
        return a + (a-b)/2;
    }

    public static void main(String[] args) {

    }


}
