package aleetcode.problem.leetcode139;

import aleetcode.problem.instrument.SolutionMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/word-break/description/">单词拆分</a>
 */
public class Solution20240505 {

    @SolutionMethod(description = "回溯,会超时，空间超限")
    public boolean wordBreak(String s, List<String> wordDict) {
        List<String> path = new ArrayList<>();
        List<List<String>> resultList = new ArrayList<>();

        dfs(s, wordDict, path, resultList);

        System.out.println(resultList);
        for (List<String> strings : resultList) {
            if (String.join("", strings).equals(s)) {
                return true;
            }
        }

        return false;
    }

    private void dfs(String s, List<String> givenDict, List<String> path, List<List<String>> resultList) {

        // 递归终止条件一 满足列表个数
        if (String.join("", path).length() >= s.length()) {
            resultList.add(new ArrayList<>(path));
            return;
        }

        // 单层递归，排列 可重复
        for (int i=0; i< givenDict.size(); i++) {
            path.add(givenDict.get(i));
            dfs(s, givenDict, path, resultList);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution20240505 ss = new Solution20240505();
        System.out.println(ss.wordBreak("catsanddog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
