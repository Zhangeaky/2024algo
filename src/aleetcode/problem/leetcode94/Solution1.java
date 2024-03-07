package aleetcode.problem.leetcode94;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> resultList = new ArrayList<>();

        if (null == root) {
            return resultList;
        }

        traversal(root, resultList);

        return resultList;
    }

    private void traversal(TreeNode node, List<Integer> resultList) {

        if (node.left !=null) {
            traversal(node.left, resultList);
        }

        resultList.add(node.val);

        if (node.right != null) {
            traversal(node.right, resultList);
        }
    }
}
