package leetcode.algorithm.section6;

/**
 * 132. 分割回文串 II
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 * <p>
 * 提示：
 * 1 <= s.length <= 2000
 * s 仅由小写英文字母组成
 * 
 */
public class Solution132 {
    public int minCut(String s) {

        return 0;
    }

    private boolean isPalindrome(String str) {
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
