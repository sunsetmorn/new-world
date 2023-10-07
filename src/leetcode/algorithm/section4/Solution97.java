package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution97
 * @description:
 * @date 2023年09月26日
 */

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 交错字符串
 *
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 注意：a + b 意味着字符串 a 和 b 连接。
 *
 * 提示：
 *
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 */
public class Solution97 {

    /**
     * 动态规划
     * 正向，所有路径全部计算(全遍历）。
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dpv = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                char c;
                if(i == 0){
                    if(j == 0){
                        dpv[i][j] = true;
                    }else {
                        c = s3.charAt(j - 1);
                        dpv[i][j] = dpv[i][j - 1] && s2.charAt(j - 1) == c;
                    }
                }else {
                    if(j == 0){
                        c = s3.charAt(i - 1);
                        dpv[i][j] = dpv[i - 1][j] && s1.charAt(i - 1) == c;
                    }else {
                        c = s3.charAt(i + j - 1);
                        dpv[i][j] = (dpv[i - 1][j] && s1.charAt(i - 1) == c) || (dpv[i][j - 1] && s2.charAt(j - 1) == c);
                    }
                }
            }
        }
        return dpv[s1.length()][s2.length()];
    }

    /**
     * 基于动态规划的优化，利用递归走正确的路径。节约计算时间
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static boolean isInterleave2(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleave(s1, 0, s2, 0, s3, 0, new int[s1.length() + 1][s2.length() + 1]);
    }

    private static boolean isInterleave(String s1, int index1, String s2, int index2, String s3, int index3, int[][] map) {
        if(index1 == s1.length() && index2 == s2.length()) {
            return true;
        }

        if(map[index1][index2] == 1) {
            return true;
        } else if(map[index1][index2] == -1) {
            return false;
        }

        if(index1 == s1.length()) {
            boolean value = s2.charAt(index2) == s3.charAt(index3) && isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1, map);
            if(value) {
                map[index1][index2] = 1;
            } else {
                map[index1][index2] = -1;
            }
            return value;
        }

        if(index2 == s2.length()) {
            boolean value = s1.charAt(index1) == s3.charAt(index3) && isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1, map);
            if(value) {
                map[index1][index2] = 1;
            } else {
                map[index1][index2] = -1;
            }
            return value;
        }

        if(s1.charAt(index1) == s3.charAt(index3)) {
            if(isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1, map)) {
                map[index1][index2] = 1;
                return true;
            }
        }

        if(s2.charAt(index2) == s3.charAt(index3)) {
            if(isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1, map)) {
                map[index1][index2] = 1;
                return true;
            }
        }

        map[index1][index2] = -1;
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbcacc";

        System.out.println(isInterleave2(s1, s2, s3));
    }
}
