package aleetcode.problem.leetcode654;

import aleetcode.problem.instrument.Printer;
import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">最大二叉树</a>
 */
@Solution(number = 654)
public class Solution20240525 {

    @SolutionMethod("5.39%, 5.14%")
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums);
    }

    private TreeNode build(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        // 找到数组中的最大值
        int max = getMax(nums);
        int index = getIndex(nums, max);
        int[] left = getLeft(nums, index);
        System.out.println("最大值:" + max + ";" + "地址:" + index + ";");
        System.out.println("左数组:" + Arrays.toString(left));
        int[] right = getRight(nums, index);
        System.out.println("右数组:" + Arrays.toString(right));
        System.out.println("===");

        TreeNode node = new TreeNode(max);

        // 构建左子树
        node.left = build(left);
        node.right = build(right);

        return node;
    }

    private int getMax(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        return clone[clone.length-1];
    }

    private int getIndex(int[] nums, int value) {
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    private int[] getLeft(int[] nums, int middle) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        if (nums.length-1 < middle) {
            throw new RuntimeException("middle越界");
        }

        int[] result = new int[middle];

        for (int i=0; i<middle; i++) {
            result[i] = nums[i];
        }
        return result;
    }

    private int[] getRight(int[]nums, int middle) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length-1 < middle) {
            throw new RuntimeException("middle越界");
        }

        int[] result = new int[(nums.length-1-middle)];

        for (int i=0; i<result.length; i++) {
            result[i] = nums[middle+1+i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution20240525 ss =new Solution20240525();
        ss.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }


}
