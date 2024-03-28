package aleetcode.problem.leetcode17;

import java.util.ArrayList;
import java.util.List;

/**
 * 这题虽然通过，但是运行时间很长 要看下为什么？
 */
class Solution20240329 {

    private final String[] table = { "","","abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};

    private List<String> resultList;

    private String path;

    private int size;

    public List<String> letterCombinations(String digits) {

        resultList = new ArrayList<>();
        if (digits.length() == 0) {
            return resultList;
        }
        path = "";
        size = digits.length();
        dfs(digits, 0);

        return resultList;
    }

    private void dfs(String digits, int index) {

        // 递归终止条件
        if (size == path.length()) {
            resultList.add(path);
            return;
        }

        for (int i=0; i<table[Character.getNumericValue(digits.charAt(index))].length(); i++) {
            String currentString = table[Character.getNumericValue(digits.charAt(index))];
            path = path + currentString.charAt(i);
            dfs(digits, index+1);
            path = path.substring(0, path.length() - 1);
        }

    }

    public static void main(String[] args) {

      Solution20240329 ss = new Solution20240329();
        System.out.println(ss.letterCombinations("23456"));
    }
}