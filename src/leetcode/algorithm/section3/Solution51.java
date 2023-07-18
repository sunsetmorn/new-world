package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n皇后问题 研究的是如何将n个皇后放置在n×n的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数n，返回所有不同的n皇后问题的解决方案。
 * 每一种解法包含一个不同的n皇后问题的棋子放置方案，该方案中'Q'和'.'分别代表了皇后和空位。
 *
 * 提示：
 * 1 <= n <= 9
 */
public class Solution51 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        boolean[] x = new boolean[n];
        boolean[] y = new boolean[n];
        boolean[] a = new boolean[2*n-1];
        boolean[] p = new boolean[2*n-1];
        boolean[][] box = new boolean[n][n];
        solveNQueensHelper(0,x,y,a,p,box,ret);
        return ret;
    }

    private static void solveNQueensHelper(int i,boolean[] x,boolean[] y,boolean[] a,boolean[] p,boolean[][] box,List<List<String>> ret ){
        int n = x.length;
        for(int j = 0; j < n; j++) {
            if (i == n) {
                List<String> tml = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    String tmp = "";
                    for (int l = 0; l < n; l++) {
                        if (box[k][l]) {
                            tmp += "Q";
                        } else {
                            tmp += ".";
                        }
                    }
                    tml.add(tmp);
                }
                ret.add(tml);
                return;
            }
            if (!(x[i] || y[j] || a[i + j] || p[i - j + n - 1])) {
                x[i] = y[j] = a[i + j] = p[i - j + n - 1] = true;
                box[i][j] = true;
                solveNQueensHelper(i + 1, x, y, a, p, box, ret);
                x[i] = y[j] = a[i + j] = p[i - j + n - 1] = false;
                box[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(6);
        for (int i = 0; i < lists.size(); i++) {
            for (int i1 = 0; i1 < lists.get(i).size(); i1++) {
                System.out.println(lists.get(i).get(i1));
            }
            System.out.println("/");
        }
    }
}
