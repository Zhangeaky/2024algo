package aleetcode.problem.leetcode27;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;

/**
 * <a href="https://leetcode.cn/problems/remove-element/">移除元素</a>
 */
@Solution(number = 27)
public class Solution20240522 {

    @SolutionMethod(description = "头尾指针")
    public int removeElement(int[] nums, int val) {

        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            if (nums[left] == val && nums[right] != val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
                continue;
            }
            if (nums[left] != val && nums[right] == val) {
                left++;
                right--;
                continue;
            }
            if (nums[left] != val && nums[right] != val) {
                left++;
                continue;
            }
            if (nums[left] == val && nums[right] == val) {
                right--;
            }
        }

        int i=1;
        for (;i<=nums.length; i++) {
            if (nums[i-1] == val) {
                break;
            }
        }
        return i-1;
    }

    @SolutionMethod(description = "快慢指针")
    public int removeElement__(int[] nums, int val) {

        int quick = 0;
        int slow = 0;
        for (;quick<nums.length; quick++) {
            if (quick != val) {
                nums[slow] = nums[quick];
                slow++;
            }
        }
        return slow+1;
    }



    }


