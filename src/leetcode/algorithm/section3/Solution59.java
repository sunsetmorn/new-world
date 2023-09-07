package leetcode.algorithm.section3;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n x n 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵
 * 1 <= n <= 20
 */
public class Solution59 {

    public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int type = 1;
        int i = 0,j = 0;
        for(int k = 1; k <= n * n; k++){
            ret[i][j] = k;
            if(type == 1){
                if(j + 1 >= n || ret[i][j + 1] > 0){
                    type = 2;
                    i++;
                }else {
                    j++;
                }
            }else if(type == 2){
                if(i + 1 >= n || ret[i + 1][j] > 0){
                    type = 3;
                    j--;
                }else {
                    i++;
                }
            }else if(type == 3){
                if(j - 1 < 0 || ret[i][j - 1] > 0){
                    type = 4;
                    i--;
                }else {
                    j--;
                }
            }else if(type == 4){
                if(i - 1 < 0 || ret[i - 1][j] > 0){
                    type = 1;
                    j++;
                }else {
                    i--;
                }
            }
        }
        return  ret;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(5);
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                System.out.print(ints[i][i1]+",");
            }
            System.out.println();
        }
    }
}
