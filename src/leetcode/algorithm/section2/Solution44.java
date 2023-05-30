package leetcode.algorithm.section2;

import java.util.HashMap;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 *
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符?和*。
 *
 */
public class Solution44 {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if(p.charAt(i - 1) == '*'){
                dp[0][i] = true;
            }else{
                break;
            }
        }
        for (int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j){
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                }else if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public boolean isMatch2(String s, String p) {
        int i=0,j=0,iR=-1,jR=-1,i_len=s.length(),j_len=p.length();
        while (i<i_len){
            if (j<j_len&&p.charAt(j)=='*'){
                j++;
                jR=j;
                iR=i;
            }else if (j<j_len&&(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                i++;
                j++;
            }else if (iR>=0){
                iR++;
                i=iR;
                j=jR;
            }else {
                return false;
            }
        }
        while (j<j_len&&p.charAt(j)=='*'){
            j++;
        }
        return j==j_len;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa","*"));
        System.out.println(isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b"));
    }
}