package leetcode.algorithm.section2;

/**
 * ����һ��n��n�Ķ�ά����matrix��ʾһ��ͼ�����㽫ͼ��˳ʱ����ת 90 �ȡ�
 * �������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
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
