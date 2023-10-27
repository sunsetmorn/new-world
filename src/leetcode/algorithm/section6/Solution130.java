package leetcode.algorithm.section6;

import org.junit.Test;

/**
 * @author zhaoxq
 * @ClassName Solution130
 * @description:
 * @date 2023年10月27日
 * <p>
 * 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */

public class Solution130 {
    public void solve(char[][] board) {
        // 0未判断，1 需要改，2待定，3不需要改,4 X
        int[][] state = new int[board.length][board[0].length];
        setState(board,state);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && state[i][j] == 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void setState(char[][] board, int[][] state) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                set(board,state,i,j);
            }
        }
    }

    private void set(char[][] board, int[][] state,int i,int j){
        if(board[i][j] == 'X'){
            state[i][j] = 4;
        } else {
            if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                state[i][j] = 3;
            } else {
                if(state[i - 1][j] == 3 || state[i + 1][j] == 3 || state[i][j- 1] == 3 || state[i][j + 1] == 3){
                    state[i][j] = 3;
                }else{
                    state[i][j] = 1;
                }
            }
        }
        if(state[i][j] == 3){
            if(i - 1 > 0 && (state[i - 1][j] != 3 && state[i - 1][j] != 4)){
                set(board,state,i - 1,j);
            }
            if(i + 1 < board.length - 1 && (state[i + 1][j] != 3 && state[i + 1][j] != 4)){
                set(board,state,i + 1,j);
            }
            if(j + 1 < board[0].length - 1 && (state[i][j + 1] != 3 && state[i][j + 1] != 4)){
                set(board,state,i,j + 1);
            }
            if(j - 1 > 0 && (state[i][j - 1] != 3 && state[i][j - 1] != 4)){
                set(board,state,i,j - 1);
            }
        }
    }


    @Test
    public void test() {
//        char[][] a = {{'X', 'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'O', 'X'}, {'X', 'X', 'O', 'O', 'X'}, {'X', 'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X', 'X'}};
//        char[][] a = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] a = {{'O','O','O','O','X','X'}
                    ,{'O','O','O','O','O','O'}
                    ,{'O','X','O','X','O','O'}
                    ,{'O','X','O','O','X','O'}
                    ,{'O','X','O','X','O','O'}
                    ,{'O','X','O','O','O','O'}};
        solve(a);
        System.out.println("111");
    }


    public void solve1(char[][] board) {
        // 第一行
        for (int j = 0; j < board[0].length; j++) {
            dfsConnLand(board, 0, j);
        }
        // 第一列
        for (int i = 1; i < board.length; i++) {
            dfsConnLand(board, i, 0);
        }
        // 最后一行
        for (int j = 1; j < board[0].length; j++) {
            dfsConnLand(board, board.length - 1, j);
        }
        // 最后一列
        for (int i = 1; i < board.length; i++) {
            dfsConnLand(board, i, board[0].length - 1);
        }
        // 把剩下的‘O’刷成‘X’
        solve(board, 'O', 'X');
        solve(board, 'L', 'O');
    }



    // 把和陆地相连的岛屿刷成L
    private void dfsConnLand(char[][] board, int x, int y) {
        if (!availablePoint(board, x, y)) {
            return;
        }
        board[x][y] = 'L';
        dfsConnLand(board, x, y + 1);
        dfsConnLand(board, x + 1, y);
        dfsConnLand(board, x, y - 1);
        dfsConnLand(board, x - 1, y);
    }

    private boolean availablePoint(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            // 超出边界
            return false;
        }
        // 没掉进水里且没有被访问过
        return board[x][y] == 'O';
    }

    // 把source刷成target
    private void solve(char[][] board, char source, char target) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == source) {
                    board[i][j] = target;
                }
            }
        }
    }

}
