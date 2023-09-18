package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution87
 * @description:
 * @date 2023年09月15日
 */

/**
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 * 提示：
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 和 s2 由小写英文字母组成
 *
 */

import java.util.HashMap;
import java.util.Map;

/**
 * s1 和 s2 扰乱
 * 存在位置i(i < s1.length), 使得s1在i处分割的两个子串s11、s12分别和s2在i处分割的两个子串s21、s22扰乱。或者和s2在length-i出分割的两个字符串（s23、s24）扰乱
 * 即 （s11 与 s21 扰乱 且 s12 与 s22 扰乱） 或者 （s11 与 s24 扰乱 且 s12 与 s23 扰乱）
 *
 * s1 和 s2 扰乱
 * 则 s1和s2的长度相同，且s1和s2中各字符的数量相同
 */
public class Solution87 {
    // -1 表示 false，1 表示 true，0 表示未计算
    int[][][] memo;
    String s1,s2;

    public boolean isScramble2(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        int length = s1.length();
        this.memo = new int[length][length][length + 1];
        return dfs(0,0,length);
    }

    private boolean dfs(int i1,int i2,int length){
        if(memo[i1][i2][length] != 0 ){
            return memo[i1][i2][length] == 1;
        }
        // 判断两个子串是否相等
        if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
            memo[i1][i2][length] = 1;
            return true;
        }
        // 判断是否存在字符 c 在两个子串中出现的次数不同
        if (!checkIfSimilar(i1, i2, length)) {
            memo[i1][i2][length] = -1;
            return false;
        }
        // 枚举分割位置
        for (int i = 0; i < length; i++) {
            //不交换的场景
            if(dfs(i1,i2,i) && dfs(i1 + i,i2 + i,length - i)){
                memo[i1][i2][length] = 1;
                return true;
            }
            //交换的场景
            if(dfs(i1,i2 + length - i,i) && dfs(i1 + i,i2,length - i)){
                memo[i1][i2][length] = 1;
                return true;
            }
        }
        memo[i1][i2][length] = -1;
        return false;
    }

    public boolean checkIfSimilar(int i1, int i2, int length) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = i1; i < i1 + length; ++i) {
            char c = s1.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int i = i2; i < i2 + length; ++i) {
            char c = s2.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int value = entry.getValue();
            if (value != 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        boolean[][][] f = new boolean[n][n][n + 1];

        // 先处理长度为 1 的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][1] = cs1[i] == cs2[j];
            }
        }

        // 再处理其余长度情况
        for (int len = 2; len <= n; len++) {
            // 枚举 s1 中的起点位置
            for (int i = 0; i <= n - len; i++) {
                // 枚举 s2 中的起点位置
                for (int j = 0; j <= n - len; j++) {
                    //对len长度进行划分位置，枚举获取结果
                    for (int k = 1; k < len; k++) {
                        boolean a = f[i][j][k] && f[i + k][j + k][len - k];
                        boolean b = f[i][j + len - k][k] && f[i + k][j][len - k];
                        if (a || b) {
                            f[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }


    /**
     * 最短时间算法
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble3(String s1, String s2) {
        return isMatch(s1.toCharArray(), s2.toCharArray(), 0, 0, s1.length(), null);
    }

    boolean isMatch(char[] chars1, char[] chars2, int start1, int start2, int offset, Boolean left) {
        if (offset == 1) {
            return chars1[start1] == chars2[start2];
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        int count1 = 0, count2 = 0;
        for (int i = 0; i < offset - 1; i++) {
            if (left == null || left) {
                if (++map1[chars1[start1 + i] - 'a'] <= 0) {
                    count1--;
                } else {
                    count1++;
                }
                if (--map1[chars2[start2 + i] - 'a'] >= 0) {
                    count1--;
                } else {
                    count1++;
                }
                if (count1 == 0 && isMatch(chars1, chars2, start1, start2, i + 1, false)) {
                    if (isMatch(chars1, chars2, start1 + i + 1, start2 + i + 1, offset - i - 1, null)) {
                        return true;
                    }
                }
            }
            if (left == null || !left) {
                if (++map2[chars1[start1 + i] - 'a'] <= 0) {
                    count2--;
                } else {
                    count2++;
                }
                if (--map2[chars2[start2 + offset - i - 1] - 'a'] >= 0) {
                    count2--;
                } else {
                    count2++;
                }
                if (count2 == 0 && isMatch(chars1, chars2, start1, start2 + offset - i - 1, i + 1, true)) {
                    return isMatch(chars1, chars2, start1 + i + 1, start2, offset - i - 1, null);
                }
            }
        }
        return false;
    }

}
