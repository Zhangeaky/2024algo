package aleetcode.problem.leetcode139;

import aleetcode.problem.instrument.SolutionMethod;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution20240506 {


    @SolutionMethod(description = "动态规划版本")
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> stringSet = new HashSet<>(wordDict);

        // dp 数组的含义：
        // 长度为i的字符串，能在wordDict中拼接出来的结果为dp[i]
        boolean[] dp = new boolean[s.length()+1];

        //dp 数组初始化
        // 0 的语义是长度为0的字符串，能否通过字典中的字符串拼接
        dp[0] = true;

        //遍历顺序确定：先遍历背包，后遍历物品，因为这是一个组合问题。
        // 需要注意这个长度的的区间开闭
        for (int i=0; i<=s.length(); i++) {
            String currentString = s.substring(0, i);
            for (int j=0; j<i; j++) {
                String subString = s.substring(j, i);
                if (dp[j] && wordDict.contains(subString)) {
                    dp[i] = true;
                }

            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

//        Solution20240506 ss = new Solution20240506();
//        System.out.println(ss.wordBreak("abcdef", Arrays.asList("abc", "def")));
        System.out.println("012345678".substring(0, 9));

    }
}
