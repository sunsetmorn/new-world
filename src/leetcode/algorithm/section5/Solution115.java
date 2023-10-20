package leetcode.algorithm.section5;

import java.util.Arrays;

/**
 * @author zhaoxq
 * @ClassName Solution115
 * @description:
 * @date 2023年10月19日
 * <p>
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10000000 + 7 取模。
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 */

public class Solution115 {
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if(t.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }

    /**
     * 使用递归 从结尾来获取开头，避开动态规划全量计算中的非必要计算部分。
     * 并且又加了反向方式dp，dp[i][j]表示 S的第i个字符到结尾组成的字符串 中包含 T的第j个字符到结尾的字符串 个数。
     */
    int[][] memo;
    public int numDistinct1(String s, String t) {
        memo = new int[s.length()][t.length()];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return helper(s, t, 0, 0);
    }

    private int helper(String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (memo[i][j] > -1) return memo[i][j];

        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans += helper(s, t, i + 1, j + 1) + helper(s, t, i + 1, j);
        } else {
            ans += helper(s, t, i + 1, j);
        }

        memo[i][j] = ans;
        return ans;
    }
}
