package leetcode.algorithm.section3;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 */
public class Solution73 {
    public static void setZeroes(int[][] matrix) {
        int l1 = matrix.length;
        int l2 = matrix[0].length;
        boolean[] i = new boolean[l1];
        boolean[] j = new boolean[l2];
        for (int k = 0; k < l1; k++) {
            for (int l = 0; l < l2; l++) {
                if(matrix[k][l] == 0){
                    i[k] = true;
                    j[l] = true;
                }
            }
        }
        for (int k = 0; k < l1; k++) {
            if (i[k]){
                for (int l = 0; l < l2; l++) {
                    matrix[k][l] = 0;
                }
            }
        }
        for (int k = 0; k < l2; k++) {
            if (j[k]){
                for (int l = 0; l < l1; l++) {
                    matrix[l][k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(a);
        for (int i = 0; i < a.length; i++) {
            for (int i1 : a[i]) {
                System.out.print(i1+",");
            }
            System.out.println();
        }
    }
}
