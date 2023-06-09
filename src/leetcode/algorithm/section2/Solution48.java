package leetcode.algorithm.section2;

/**
 * 给定一个n×n的二维矩阵matrix表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 */
public class Solution48 {
    public static void rotate(int[][] matrix) {
        if(matrix.length == 0) return;
        for(int i = 0; i < matrix.length/2; i++){
            for(int j = i; j < matrix.length - i - 1; j++){
                matrix = change(matrix,i,j);
            }
        }
    }
    private static int[][] change(int[][] matrix,int x,int y){
        int tmp = matrix[x][y];
        int n = matrix.length;
        matrix[x][y] = matrix[n-y-1][x];
        matrix[n-y-1][x] = matrix[n-x-1][n-y-1];
        matrix[n-x-1][n-y-1] = matrix[y][n-x-1];
        matrix[y][n-x-1] = tmp;
        return matrix;
    }

    public static void main(String[] args) {
        /**
         [[1,2,3],
         [4,5,6],
         [7,8,9]]
         */
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        for (int[] ints : a) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + ",");
            }
            System.out.println();
        }
        rotate(a);

        for (int[] ints : a) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + ",");
            }
            System.out.println();
        }
    }
}
