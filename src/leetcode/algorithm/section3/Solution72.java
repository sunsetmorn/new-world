package leetcode.algorithm.section3;

import java.util.Arrays;

/**
 * 给你两个单词 word1 和 word2 ,请返回将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class Solution72 {
    public static int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if(l1 * l2 == 0) return l1 + l2;
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= l1; i++){
            for (int j = 1; j <= l2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1],dp[i - 1][j]),dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        System.out.println(minDistance(a, b));
    }

    /**
     * 备忘录
     */
    int[][] memo;

    /**
     * 1. 动态规划（带备忘录递归）
     */
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 为备忘录初始化特殊值
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        return dp(word1, m - 1, word2, n - 1);
    }

    /**
     * 定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
     */
    int dp(String s1, int i, String s2, int j) {
        // base case
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }

        // 查备忘录防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 状态转移
        if (s1.charAt(i) == s2.charAt(j)) {
            // 如果当前两字符相同，则不做任何操作，同时移动指针（由于两字符相同，算不算上它对编辑距离没有影响）
            memo[i][j] = dp(s1, i - 1, s2, j - 1);
        } else {
            // 如果当前两字符不相同，则问题转化成 子问题（替换、删除、插入）的最优答案+1
            memo[i][j] = 1 + Math.min(dp(s1, i - 1, s2, j - 1), Math.min(dp(s1, i - 1, s2, j), dp(s1, i, s2, j - 1)));
        }

        return memo[i][j];
    }
}
