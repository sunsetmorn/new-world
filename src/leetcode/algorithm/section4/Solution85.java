package leetcode.algorithm.section4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhaoxq
 * @ClassName Solution85
 * @description:
 * @date 2023年09月07日
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 */

public class Solution85 {

    /**
     * 每个单元格计算左侧（或者上侧）的连续1元素个数，得到的数字矩阵按列（行）可以当成前一题的连续矩形面积计算。
     * 最终求得最大值。
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] area = new int[m][n];
        for (int i = 0; i < m; i++) {
            area[i][0] = matrix[i][0] == '0' ? 0 : 1;
            for (int j = 1; j < n; j++) {
                area[i][j] = matrix[i][j] == '0' ? 0 : area[i][j - 1] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] left = new int[m];
            int[] right = new int[m];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = 0; j < m; j++) {
                while (!stack.isEmpty() && area[stack.peek()][i] >= area[j][i]) {
                    stack.pop();
                }
                left[j] = (stack.isEmpty() ? -1 : stack.peek());
                stack.push(j);
            }
            stack.clear();
            for (int j = m - 1; j >= 0; j--) {
                while (!stack.isEmpty() && area[stack.peek()][i] >= area[j][i]) {
                    stack.pop();
                }
                right[j] = (stack.isEmpty() ? m : stack.peek());
                stack.push(j);
            }
            for (int j = 0; j < m; j++) {
                max = Math.max(max, area[j][i] * (right[j] - left[j] - 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] a = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(a));
    }
}
