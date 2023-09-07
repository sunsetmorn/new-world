package leetcode.algorithm.section3;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 每行中的整数从左到右按非递减顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10000 <= matrix[i][j], target <= 10000
 *
 */
public class Solution74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n = matrix[0].length;
        if(matrix[0][0] > target || matrix[m - 1][n - 1] < target) return false;
        int start = 0,end = m - 1;
        while (start != end){
            if(matrix[(start + end)/2][0] == target || matrix[(start + end)/2][n - 1] == target) {
                return true;
            }else if(matrix[(start + end)/2][0] < target){
                start = (start + end)/2;
            }else if(matrix[(start + end)/2][0] > target){
                end = (start + end)/2;
            }
            if(start == end - 1){
                if(matrix[start][0] == target || matrix[start][n - 1] == target) return true;
                if(matrix[end][0] == target || matrix[end][n - 1] == target) return true;
                if(matrix[start][0] < target && matrix[start][n - 1] > target){
                    end = start;
                }else if(matrix[end][0] < target && matrix[end][n - 1] > target){
                    start = end;
                }else {
                    return false;
                }
            }
        }
        int t = start;
        start = 0;
        end = n - 1;
        while (true){
            if(matrix[t][start] == target || matrix[t][end] == target) {
                return true;
            }else if(start == end - 1){
                return false;
            }
            if(matrix[t][(start + end)/2] < target){
                start = (start + end)/2;
            }else if(matrix[t][(start + end)/2] == target){
                return true;
            }else {
                end = (start + end)/2;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1},{3},{5}};
        int b = 3;
        System.out.println(searchMatrix(a, b));
    }

}
