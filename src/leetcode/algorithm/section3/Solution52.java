package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题 研究的是如何将n个皇后放置在n × n的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数n，返回n皇后问题不同的解决方案的数量。
 * 1 <= n <= 9
 */
public class Solution52 {
    public static int totalNQueens(int n) {
        int ret = 0;
        boolean[] x = new boolean[n];
        boolean[] y = new boolean[n];
        boolean[] a = new boolean[2*n-1];
        boolean[] p = new boolean[2*n-1];
        boolean[][] box = new boolean[n][n];
        return solveNQueensHelper(0, x, y, a, p, box, ret);
    }

    private static int solveNQueensHelper(int i,boolean[] x,boolean[] y,boolean[] a,boolean[] p,boolean[][] box,int ret ){
        int n = x.length;
        for(int j = 0; j < n; j++) {
            if (i == n) {
                return ++ret;
            }
            if (!(x[i] || y[j] || a[i + j] || p[i - j + n - 1])) {
                x[i] = y[j] = a[i + j] = p[i - j + n - 1] = true;
                box[i][j] = true;
                ret = solveNQueensHelper(i + 1, x, y, a, p, box, ret);
                x[i] = y[j] = a[i + j] = p[i - j + n - 1] = false;
                box[i][j] = false;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(2));
    }
}
