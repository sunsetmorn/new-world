package leetcode.algorithm.section1;

/**
 * 实现基础正则字符"*","."
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * a* 可以表述0个a，即*可以表示-1个a。
 */
public class Solution10 {
    /**
     * 动态规划
     * 设置二维布尔数组表示s、p的字符串的匹配度。booleans[i+1][j+1]表示s的前i位和p的前j位是否匹配。
     *
     */
    public static boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()) return true;
        if(s.equals(p)) return true;
        if(p.isEmpty() && !s.isEmpty()) return false;
        boolean[][] booleans = new boolean[s.length()+1][p.length()+1];
        booleans[0][0] = true;
        for (int i = 1; i < p.length()+1; i++) {
            if (p.charAt(i - 1) == '*') {
                booleans[0][i] = booleans[0][i - 2];
            }
        }
        for(int i =1;i < s.length()+1;i++){
            for(int j =1;j < p.length()+1;j++){
                if(p.charAt(j - 1)== s.charAt(i - 1) || p.charAt(j - 1)== '.'){
                    booleans[i][j] = booleans[i - 1][j - 1];
                }else if(p.charAt(j - 1)=='*'){
                    if(p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'){
                        booleans[i][j] = booleans[i][j-1] || booleans[i][j - 2] || booleans[i - 1][j] ;
                    }else{
                        booleans[i][j] = booleans[i][j - 2];
                    }
                }else{
                    booleans[s.length()][p.length()] = false;
                }
            }
        }
        return booleans[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String a ="";
        String b = ".*";
//        String b = a.substring(1,3); //[)
//        System.out.println(b);
        System.out.println(isMatch(a,b));
    }
}
