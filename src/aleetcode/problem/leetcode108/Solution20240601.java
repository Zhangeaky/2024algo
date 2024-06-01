package aleetcode.problem.leetcode108;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked">
 *     将有序数组转化为二叉搜索树</a>
 */
@Solution
public class Solution20240601 {

    @SolutionMethod
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        // 获取中节点
        int middle = (nums.length)/2;
        TreeNode node = new TreeNode(nums[middle]);

        // 设置左节点
        //
        node.left = sortedArrayToBST(buildBeforeArray(nums, middle));

        // 设置右节点
        node.right = sortedArrayToBST(buildAfterArray(nums, middle));

        return node;
    }

    int[] buildBeforeArray(int[] nums, int index) {

        int[] array = new int[index];

        for (int i=0; i<index; i++) {
            array[i] = nums[i];
        }

        return array;
    }

    int[] buildAfterArray(int[] nums, int index) {
        int[] array = new int[nums.length-1-index];
        for (int i=0; i<nums.length-1-index; i++) {
            array[i] = nums[index+1+i];
        }
        return array;
    }

    public static void main(String[] args) {
        Solution20240601 ss = new Solution20240601();
        TreeNode treeNode = ss.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println();

    }
}
