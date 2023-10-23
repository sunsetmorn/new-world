package leetcode.algorithm.section5;

/**
 * @author zhaoxq
 * @ClassName Solution125
 * @description:
 * @date 2023年10月23日
 * <p>
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串s，如果它是回文串，返回true；否则，返回false 。
 * <p>
 * 提示：
 * 1 <= s.length <= 2 * 100000
 * s 仅由可打印的 ASCII 字符组成
 */

public class Solution125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        String s1 = s.toLowerCase();
        while (left < right) {
            char cLeft = s1.charAt(left);
            char cRight = s1.charAt(right);
            if (isValid(cLeft)) {
                left++;
                continue;
            }
            if (isValid(cRight)) {
                right--;
                continue;
            }
            if(cLeft != cRight){
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isValid(char a) {
        if (a > 'z' || a < '0') {
            return true;
        } else return a > '9' && a < 'a';
    }
}
