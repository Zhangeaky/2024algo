package aleetcode.problem.leetcode102;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">...</a>
 */
@Solution
public class Solution20240517 {

    @SolutionMethod
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {

            int originSize = queue.size();

            // 处理每一层
            List<Integer> levelList = new ArrayList<>();
            for (int i=0; i<originSize; i++) {

                TreeNode firstNode = queue.poll();
                levelList.add(firstNode.val);

                if (firstNode.left != null) {
                    queue.offer(firstNode.left);
                }
                if (firstNode.right != null) {
                    queue.offer(firstNode.right);
                }
            }
            // 一层处理完之后 把每一层处理结果放入最终的结果
            resultList.add(levelList);
        }

        return resultList;
    }
}
