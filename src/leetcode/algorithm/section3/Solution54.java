package leetcode.algorithm.section3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 */
public class Solution54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int flag = 1;
        int cycle = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        while (ret.size() < m * n){
            if(flag == 1 && cycle <= n - cycle - 1){
                for(int i = cycle; i <= n - cycle - 1; i++){
                    ret.add(matrix[cycle][i]);
                }
                flag++;
            }else if(flag == 2 && cycle <= m - cycle - 1){
                for(int i = cycle + 1; i <= m - cycle - 1; i++){
                    ret.add(matrix[i][n - cycle - 1]);
                }
                flag++;
            }else if(flag == 3 && n - cycle - 1 >= cycle){
                for(int i = n - cycle - 2; i >= cycle; i--){
                    ret.add(matrix[m - cycle - 1][i]);
                }
                flag++;
            }else if(flag == 4 && m - cycle - 1 >= cycle){
                for(int i = m - cycle - 2; i > cycle; i--){
                    ret.add(matrix[i][cycle]);
                }
                flag = 1;
                cycle++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}};
        List<Integer> list = spiralOrder(matrix);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}
