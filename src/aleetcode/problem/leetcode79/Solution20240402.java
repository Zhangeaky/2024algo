package aleetcode.problem.leetcode79;


/**
 * <a href="https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked">单词搜索</a>
 */
public class Solution20240402 {

    private String word;

    private StringBuilder path = new StringBuilder();

    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() ==0) {
            return false;
        }

        this.word = word;
        if (board == null || board.length == 0) {
            return false;
        }
        dfs(board, 0);
        return path.length() == word.length();
    }

    private void dfs(char[][] board, int index) {

        //终止条件1
        if (path.length() == word.length()) {
            return;
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (!(board[i][j] == word.charAt(index))) {
                    continue;
                }
                path.append(board[i][j]);
                dfs(board, index+1);
                if (path.length() == word.length()) {
                    return;
                }
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution20240402 ss = new Solution20240402();

        char[][] board = {
            {'A','B','C','D'},
            {'A','B','C','D'},
            {'A','B','C','D'},
        };

        System.out.println(ss.exist(board, "AAAAA"));
    }

}
