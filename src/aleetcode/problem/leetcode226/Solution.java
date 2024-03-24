package aleetcode.problem.leetcode226;

import aleetcode.problem.leetcode94.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        process(root);
        return root;
    }

    private void process(TreeNode node) {

        // 节点为空不处理
        if (node == null) {
            return;
        }

        process(node.right);
        process(node.left);

        TreeNode temp = node.right;
        node.right = node.left;;
        node.left = temp;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);

        TreeNode temp = one;
        one = two;
        two = temp;
        System.out.printf("");

    }
}