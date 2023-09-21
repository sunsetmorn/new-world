package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution91
 * @description:
 * @date 2023年09月21日
 */

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要解码已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 */
public class Solution91 {
    public static int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        return count(0,s,false);
    }

    private static int count(int a,String s,Boolean flag){
        if(!flag && s.charAt(a) == '0') return 0;
        if(a + 1 == s.length()) return 1;
        if(!flag){
            if(s.charAt(a) == '1' || (s.charAt(a) == '2' && s.charAt(a + 1) <= '6')){
                return  count(a + 1, s, true) + count(a + 1, s, false);
            }
        }
        return count(a + 1, s, false);
    }

    public static int numDecodings2(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings2("1201234"));
    }
}
