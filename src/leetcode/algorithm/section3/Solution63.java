package leetcode.algorithm.section3;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 */
public class Solution63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] ret = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] != 1){
                ret[i][0] = 1;
            }else {
                break;
            }
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] != 1){
                ret[0][i] = 1;
            }else {
                break;
            }
        }
        for(int i = 1; i < obstacleGrid.length; i++){
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1){
                    ret[i][j] = 0;
                }else {
                    ret[i][j] = ret[i][j - 1] + ret[i - 1][j];
                }
            }
        }
        return ret[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] r ={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(r));
    }
}
