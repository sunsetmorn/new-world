package leetcode.algorithm.section4;

import java.util.Arrays;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 提示：
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class Solution79 {
    static int m,n;
    static boolean[][] used;
    public static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(fill(board,word,i,j,0)) return true;
                }
            }
        }
        return false;
    }

    private static boolean fill(char[][] board, String word,int i, int j, int flag){
        if(flag == word.length() - 1) return true;
        used[i][j] = true;
        if(i - 1 >= 0 && !used[i - 1][j] && board[i - 1][j] == word.charAt(flag + 1)){
            if(fill(board,word,i - 1,j,flag + 1)) return true;
        }
        if(i + 1 < m && !used[i + 1][j] && board[i + 1][j] == word.charAt(flag + 1)){
            if(fill(board,word,i + 1,j,flag + 1)) return true;
        }
        if(j - 1 >= 0 && !used[i][j - 1] && board[i][j - 1] == word.charAt(flag + 1)){
            if(fill(board,word,i,j - 1,flag + 1)) return true;
        }
        if(j + 1 < n && !used[i][j + 1] && board[i][j + 1] == word.charAt(flag + 1)){
            if(fill(board,word,i,j + 1,flag + 1)) return true;
        }
        used[i][j] = false;
        return false;
    }

    public boolean exist2(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(isValid(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean isValid(char[][] board, String s, int i, int j, int level){
        if(level == s.length()) return true;
        else if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != s.charAt(level)) return false;
        board[i][j] ^= 256;
        boolean cur =  isValid(board, s, i + 1, j, level + 1) || isValid(board, s, i - 1, j, level + 1) || isValid(board, s, i, j + 1, level + 1) || isValid(board, s, i, j - 1, level + 1);
        board[i][j] ^= 256;
        return cur;
    }

    public static void main(String[] args) {
        char[][] a = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String b = "AAB";
        System.out.println(exist(a, b));
    }
}
