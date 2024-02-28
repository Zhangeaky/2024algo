package aleetcode.problem.leetcode51;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * <a href="https://leetcode.cn/problems/n-queens/description/?envType=study-plan-v2&envId=top-100-liked">
 *     N. Queen</a>
 */
public class Solution1 {


    private final String Q = "Q";

    private final String P = ".";


    public List<List<String>> solveNQueens(int n) {

        List<List<String>> resultList = new ArrayList<>();

        if (n <= 0) {
            return resultList;
        }

        generate(n, 0, new ArrayList<>(), resultList);
        return resultList;
    }


    // n 常数 deep 从0开始
    private void generate(int n, int deep, List<String> listOfRow, List<List<String>> resultList) {

        //递归退出条件 如果深度到了棋盘的最大值
        if (deep > n) {
            return;
        }

        // 遍历列
        StringBuilder element = new StringBuilder();
        for (int index=0; index<n; index++ ) {
            if (satisfied(deep, index, listOfRow, n)) {
                element.append(Q);
            } else {
                element.append(P);
            }
        }
        listOfRow.add(element.toString());
        generate(n, deep++, listOfRow, resultList);

    }

    // 判断该点位是否满足放置皇后的条件
    private boolean satisfied(int x, int y, List<String> chessBoard, int N) {

        ChessBoard cb = ChessBoard.of(chessBoard, N);

        //1. 横线是否满足
        boolean row = cb.row(x, y);

        //2. 竖线是否满足
        boolean clo = cb.clo(x, y);

        //3. 右斜线满足
        boolean rl = cb.rightLine(x, y);

        //4. 左斜线满足
        boolean ll = cb.leftLine(x, y);

        return row && clo && rl && ll;
    }

    static class ChessBoard {

        public static ChessBoard of(List<String> ele, int size) {
            return new ChessBoard(ele, size);
        }

        private List<String> chessBoard;

        private int N;

        private final  char point = '.';

        private final  char queen = 'Q';


        public ChessBoard(List<String> chessBoard, int N) {
            this.chessBoard = chessBoard;
            this.N = N;
        }

        public boolean row(int x, int y) {

            // 这一行还没有放置任何棋子
            if (chessBoard.size() < x+1) {
                return true;
            }


            String s = Optional.ofNullable(chessBoard.get(x)).orElse("");
            int length = s.length();

            int indexEnd = (length < y+1) ? y : length-1;

            for (int i=0; i<indexEnd; i++) {
                if (i != y && point == s.charAt(i)) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }

        public boolean clo(int x, int y) {

            for (int i=0; i<N; i++ ) {

                if (i != x && point == chessBoard.get(i).charAt(x)) {

                } else {
                    return false;
                }
            }

            return true;
        }

        public boolean leftLine(int x, int y) {
            return true;
        }

        public boolean rightLine(int x, int y) {
            return true;
        }

        public static void main(String[] args) {
            String ss = "abc";
            System.out.println(ss.charAt(3));
        }
    }
}
