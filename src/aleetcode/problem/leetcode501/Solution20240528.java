package aleetcode.problem.leetcode501;

import aleetcode.problem.instrument.Solution;
import aleetcode.problem.instrument.SolutionMethod;
import aleetcode.problem.leetcode94.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/">二叉搜索树中的众数</a>
 */
@Solution(number = 501)
public class Solution20240528 {

    private List<Integer> ordered = new ArrayList<>();

    @SolutionMethod("低分做法")
    public int[] findMode(TreeNode root) {

        if (root == null) {
            return null;
        }

        toList(root);

        Map<Integer, Integer> counter = new HashMap<>();

        for (Integer integer : ordered) {
            if (counter.containsKey(integer)) {
                counter.put(integer, counter.get(integer)+1);
            } else {
                counter.put(integer, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> collect = counter.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        resultList.add(collect.get(collect.size()-1).getKey());
        for (int i=collect.size()-1; i>=0; i--) {
            if (resultList.get(0).equals(collect.get(i).getValue())) {
                resultList.add(collect.get(i).getValue());
            } else {
                break;
            }
        }

        int[] result = new int[resultList.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = resultList.get(i);
        }
        return  result;
    }

    private void toList(TreeNode node) {
        if (node == null) {
            return;
        }
        toList(node.right);
        ordered.add(node.val);
        toList(node.right);
    }

    private int counter = 0;

    private int maxCount = 0;

    private TreeNode pre = null;


    private List<Integer> res = new ArrayList<>();


    @SolutionMethod("双指针做法")
    public int[] findMode_(TreeNode root) {
        // 因为是BST所以使用中序遍历来遍历二叉树
        // 使用双支指针，来指向中序遍历顺序中的前一个节点和后一个节点
        // 将前后两个节点进行比较:
        // pre 为当前遍历节点的前节点，默认为NULL。curr为当前遍历节点。counter为当前数字出现次数。
        // maxCounter 为最大出现次数。 maxCounterCollection 为出现次数为最大次数的元素集合。
        // 1. pre 为null，二叉树中序遍历的初始化状态，计数器counter复值为1 进行初始化
        // 2. curr == pre 则计数器++
        // 3. pre != curr 计数器重启
        dfs(root);
        System.out.println(res);
        int[] ret = new int[res.size()];
        for (int i=0; i< res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    private void dfs(TreeNode node) {

        if (node == null) {
            return;
        }

        dfs(node.left);

        if (pre == null) {
            counter = 1;
        } else if (pre.val == node.val) {
            counter++;
        } else  {
            counter = 1;
        }
        // 前节点 递进
        pre = node;

        if (maxCount == counter) {
            res.add(node.val);
        }

        if (maxCount < counter) {
            maxCount = counter;
            res.clear();

            res.add(node.val);
        }

        dfs(node.right);
    }

    public static void main(String[] args) {
        Solution20240528 ss =new Solution20240528();

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        ss.findMode_(root);
    }

    }
