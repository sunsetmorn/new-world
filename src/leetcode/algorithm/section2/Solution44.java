package leetcode.algorithm.section2;
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
    public boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()) return true;
        if(s.equals(p)) return true;
        if(p.isEmpty() && !s.isEmpty()) return false;
        boolean[][] booleans = new boolean[s.length()+1][p.length()+1];
        booleans[0][0] = true;



        return false;
    }
}