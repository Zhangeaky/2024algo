package aleetcode.problem.leetcode106;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/">
 *     从中序和后序遍历构造二叉树</a>
 */
@Solution(number = 106)
public class Solution20240525 {

    @SolutionMethod("")
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (isEmpty(inorder) || isEmpty(postorder)) {
            return null;
        }

        // 从后序遍历数组中获取子树的头节点 第一层递归对应的是整棵树的根节点
        int headNode = postorder[postorder.length - 1];
        TreeNode head = new TreeNode(headNode);
        int index = getIndex(inorder, headNode);

        // 根据头结点 分割中序数组，将子树 切分为 左子树和右子树
        int[] leftInorderGroup = getLeftOfInOrder(inorder, index);
        System.out.println("左中序：" + Arrays.toString(leftInorderGroup));
        int[] rightOfInorderGroup = getRightOfInorder(inorder, index);
        System.out.println("右中序：" + Arrays.toString(rightOfInorderGroup));

        // 因为中序和后序遍历，他们的数组的排列结构相同，只是子树的排列不同。
        int[] leftPostOrderGroup = getLeftOfPostOrder(postorder, leftInorderGroup);
        System.out.println("左后序：" + Arrays.toString(leftPostOrderGroup));
        int[] rightOfPostOrderGroup = getRightOfPostOrder(postorder, rightOfInorderGroup);
        System.out.println("右后序：" + Arrays.toString(rightOfPostOrderGroup));


        head.left = buildTree(leftInorderGroup, leftPostOrderGroup);
        head.right = buildTree(rightOfInorderGroup, rightOfPostOrderGroup);

        return head;
    }

    private boolean isEmpty(int[] nums) {
        return nums == null || nums.length == 0;
    }

    private int getIndex(int[] nums, int target) {

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        throw new RuntimeException("Error Not Excepted!");

    }

    private int[] getLeftOfInOrder(int[] nums, int index) {
        int[] left = new int[index];
        for (int i=0; i<left.length; i++) {
            left[i] = nums[i];
        }
        return left;
    }

    private int[] getRightOfInorder(int[] nums, int index) {
        int[] right = new int[nums.length-1-index];
        for (int i=0; i<right.length; i++) {
            right[i] = nums[index+1+i];
        }
        return right;
    }

    private int[] getLeftOfPostOrder(int[] preLevelPost, int[] currLevelInorder) {
        int[] left = new int[currLevelInorder.length];

        for (int i=0; i<left.length; i++) {
            left[i] = preLevelPost[i];
        }
        return left;
    }

    private int[] getRightOfPostOrder(int[] preLevelPost, int[] currLevelInorder) {
        int[] right = new int[currLevelInorder.length];
        for (int i=0; i<right.length; i++) {
            right[i] = preLevelPost[preLevelPost.length-right.length-1+i];
        }
        return right;
    }

    public static void main(String[] args) {
        Solution20240525 ss = new Solution20240525();
        ss.buildTree(new int[]{4,2,5,1,6,3,7}, new int[]{4,5,2,6,7,3,1});
    }
}
