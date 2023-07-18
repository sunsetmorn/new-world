package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.List;

/**
 * ���չ�������Ĺ��򣬻ʺ���Թ�����֮����ͬһ�л�ͬһ�л�ͬһб���ϵ����ӡ�
 * n�ʺ����� �о�������ν�n���ʺ������n��n�������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * ����һ������n���������в�ͬ��n�ʺ�����Ľ��������
 * ÿһ�ֽⷨ����һ����ͬ��n�ʺ���������ӷ��÷������÷�����'Q'��'.'�ֱ�����˻ʺ�Ϳ�λ��
 *
 * ��ʾ��
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
