package aleetcode.problem.leetcode222;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/description/">完全二叉树的节点数量</a>
 */
@Solution(number = 222)
public class Solution20240521 {

    @SolutionMethod("用层序遍历")
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<TreeNode>> resultList = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<TreeNode> levelList = new ArrayList<>();

            // 需要保存个数 在后面弹出来，因为边出边如，所以要实现记录好大小
            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode poll = queue.poll();
                levelList.add(poll);
                if (null != poll.left) {
                    queue.offer(poll.left);
                }
                if (null != poll.right) {
                    queue.offer(poll.right);
                }
            }
            resultList.add(levelList);
        }

        return resultList.stream().map(List::size).reduce(0, Integer::sum);
    }


    @SolutionMethod("前序遍历")
    public int countNodes_(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<Integer> resultList = new ArrayList<>();

        counter(root, resultList);
        return resultList.size();
    }

    private void counter(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        counter(node.left, list);
        counter(node.right, list);
    }


}
