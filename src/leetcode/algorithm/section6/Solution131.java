package leetcode.algorithm.section6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxq
 * @ClassName Solution131
 * @description:
 * @date 2023年10月27日
 *
 * 131. 分割回文串
 * 给你一个字符串 s，请你将s分割成一些子串，使每个子串都是回文串 。返回 s 所有可能的分割方案。
 * 回文串是正着读和反着读都一样的字符串。
 *
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 */

public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>>  ret = new ArrayList<>();
        int[][] t = new int[s.length()][s.length()];


        return ret;
    }

    private boolean isPalindrome(String str){
        int i = 0,j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
