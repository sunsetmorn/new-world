package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.List;

/**
 * n�ʺ����� �о�������ν�n���ʺ������n �� n�������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * ����һ������n������n�ʺ����ⲻͬ�Ľ��������������
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
