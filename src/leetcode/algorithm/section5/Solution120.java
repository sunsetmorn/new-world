package leetcode.algorithm.section5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution120
 * @description:
 * @date 2023年10月18日
 * <p>
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 提示：
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10000 <= triangle[i][j] <= 10000
 */

public class Solution120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] bps = new int[triangle.size()][triangle.size()];
        bps[0][0] = triangle.get(0).get(0);
        if(triangle.size() == 1) return bps[0][0];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                bps[i][j] = Math.min(triangle.get(i).get(j) + (i == j ? 10000 * i :bps[i - 1][j]),
                        j - 1 >= 0 ? (triangle.get(i).get(j) + bps[i - 1][j - 1]) : 10000 * i);
                if(i == triangle.size() - 1){
                    min = Math.min(min,bps[i][j]);
                }
            }
        }
        return min;
    }

    int[][] dp;
    public int minimumTotal1(List<List<Integer>> triangle) {

        ArrayList<ArrayList<Integer>> arr = (ArrayList)triangle;
        dp = new int[arr.size()-1][arr.get(arr.size()-1).size()];
        for (int[] ints : dp) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }
        return dfs(arr,0,0);

    }
    private int dfs(ArrayList<ArrayList<Integer>> arr,int lasti, int level){
        if (level==arr.size()-1)return arr.get(level).get(lasti);
        if (dp[level][lasti]!=Integer.MAX_VALUE)return dp[level][lasti];

        int left = dfs(arr, lasti, level + 1);
        int right = dfs(arr, lasti + 1, level + 1);
        dp[level][lasti]=Math.min(left,right)+arr.get(level).get(lasti);
        return dp[level][lasti];
    }
}
