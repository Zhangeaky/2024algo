package aleetcode.problem.leetcode226;

import aleetcode.problem.leetcode94.TreeNode;
import com.sun.scenario.effect.Brightpass;

public class Solution20240324 {


    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        // 处理左子树
        doInvert(root);

        return root;
    }


    private void doInvert(TreeNode node) {

        if (node == null) {
            return;
        }

        doInvert(node.left);

        doInvert(node.right);

        TreeNode right = node.right;
        TreeNode left = node.left;
        node.left = right;
        node.right = left;

    }
}
