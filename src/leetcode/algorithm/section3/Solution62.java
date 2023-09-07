package leetcode.algorithm.section3;

/**
 * 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 1000000000
 */
public class Solution62 {
    public static int uniquePaths(int m, int n) {
        long ret = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ret = ret * x / y;
        }
        return (int)ret;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(10, 10));
    }
}
