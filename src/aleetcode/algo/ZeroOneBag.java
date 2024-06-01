package aleetcode.algo;

import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.List;

public class ZeroOneBag {


    @SolutionMethod("01")
    public int practice(int weight, int[] value, int[] weights) {

        //1. 确定dp数组的含义

        return 0;
    }




    // 使用一维动态数组
    @SolutionMethod
    public int backBagi(int weight, int[] value, int[] weights) {
        return 0;
    }


        // 使用二维dp数组
    @SolutionMethod
    public int backBag(int weight, int[] value, int[] weights) {
        if (weight == 0) {
            return 0;
        }

        // dp 数组的含义， 0-i之间的任意选择物品，使得背包重量小于等于j dp[i][j]表示背包的最大价值
        int[][] dp = new int[value.length][weight+1];

        // 初始化dp数组
        for (int i=0; i<value.length; i++) {
            dp[i][0] = 0;
        }
        for (int j=0; j<=weight; j++) {
            dp[0][j] = weights[0] <= j ? value[0] : 0;
        }

        for (int i=1; i<value.length; i++) {
            for (int j=0; j<=weight; j++) {
                if (weights[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], value[i] + dp[i-1][j - weights[i]]);
                }
            }
        }

        return dp[value.length-1][weight];
    }

    private int finalValue = 0;

    private int weight;

    private int currentWeight;

    private int[] value;

    private int[] weights;

    private List<Integer> path = new ArrayList<>();

    public int traversal(int weight, int[] value, int[] weights) {

        // 数据初始化
        this.weights = weights;
        this.value = value;
        this.weight = weight;
        this.currentWeight = weight;

        dfs(0);
        return finalValue;
    }

    private void dfs(int beginIndex) {

        //递归终止条件一 所有物品已经放入了背包。
        if (path.size() == value.length) {
            Integer reduce = path.stream().reduce(0, Math::addExact);
            if(reduce > finalValue) {
                this.finalValue = reduce;
            }
            return;
        }

        //递归终止条件三 索引到了末尾
        if (beginIndex == value.length-1) {

            if (currentWeight - weights[beginIndex] >= 0) {
                path.add(value[beginIndex]);
                currentWeight -= weights[beginIndex];
                Integer reduce = path.stream().reduce(0, Math::addExact);
                if(reduce > finalValue) {
                    this.finalValue = reduce;
                }
                return;
            } else {
                Integer reduce = path.stream().reduce(0, Math::addExact);
                if(reduce > finalValue) {
                    this.finalValue = reduce;
                }
                return;
            }
        }

        // 单层递归与回溯
        for (int i=beginIndex; i<value.length; i++) {
            // 将i物品放入背包
            if (currentWeight - weights[i] < 0) {
                break;
            }
            this.currentWeight -= weights[i];
            this.path.add(value[i]);
            dfs(beginIndex+1);

            this.currentWeight += weights[i];
            this.path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {

        ZeroOneBag 背包问题 = new ZeroOneBag();
        int j = 背包问题.backBag(5, new int[]{15, 20, 30, 90}, new int[]{1, 3, 4, 5});
        System.out.println(j);

        int i = 背包问题.traversal(5, new int[]{15, 20, 30, 90}, new int[]{1, 3, 4, 5});
        System.out.println(i);
    }

}
