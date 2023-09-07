package leetcode.algorithm.section3;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 *
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 */
public class Solution58 {
    public static int lengthOfLastWord(String s) {
        int ret = 0;
        boolean flag = false;
        for(int i = s.length() - 1;i >= 0;i--){
            if(s.charAt(i) != ' '){
                flag = true;
                ret++;
            }
            if(s.charAt(i) == ' ' && flag){
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String a = "a";
        System.out.println(lengthOfLastWord(a));
    }
}
