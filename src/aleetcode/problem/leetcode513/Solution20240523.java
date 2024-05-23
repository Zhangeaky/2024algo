package aleetcode.problem.leetcode513;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/description/">找树左下角的值</a>
 */
@Solution(number = 513)
public class Solution20240523 {

    @SolutionMethod("层序遍历" + "空间复杂度和时间复杂度都很低")
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> resultList = new ArrayList<>();

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode poll = queue.poll();
                if (i==0) {
                    resultList.add(poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }

        }

        return resultList.get(resultList.size()-1);
    }

}
