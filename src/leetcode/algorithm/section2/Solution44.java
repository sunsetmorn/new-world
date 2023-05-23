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
        System.out.println(s);
        System.out.println(p);
        if(s.isEmpty() && p.isEmpty()) return true;
        if(s.equals(p)) return true;
        if(p.isEmpty() && !s.isEmpty()) return false;
        if(!p.isEmpty() && s.isEmpty()){
            return p.replace("*","").length() ==0;
        }
        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'){
            return isMatch(s.substring(1),p.substring(1));
        }else if(p.charAt(0) == '*'){
            if(p.length() ==1) return true;
            for(int i =0;i < s.length();i++){
                if(isMatch(s.substring(i),p.substring(1))){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab","***bba**a*bbba**aab**b");
    }
}