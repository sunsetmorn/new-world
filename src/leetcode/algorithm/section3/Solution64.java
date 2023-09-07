package leetcode.algorithm.section3;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] r = new int[m][n];
        r[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            r[i][0] = grid[i][0] + r[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            r[0][i] = grid[0][i] + r[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                r[i][j] = Math.min(r[i][j - 1],r[i - 1][j])+grid[i][j];
            }
        }
        return r[m - 1][n - 1];
    }


    /**
     * 递归
     * 节约了一个二维数组的空间，不需要额外两次循环。
     */
    int[][] memo;

    public int minPathSum2(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        return dp(grid, grid.length - 1, grid[0].length - 1);
    }

    int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) return grid[i][j];

        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (memo[i][j] != 0) return memo[i][j];
        return memo[i][j] = Math.min(
                dp(grid, i - 1, j),
                dp(grid, i, j - 1)
        ) + grid[i][j];
    }
}
