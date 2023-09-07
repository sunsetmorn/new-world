package leetcode.algorithm.section3;


/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 *
 * 提示：
 * 1 <= a.length, b.length <= 10000
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */
public class Solution67 {
    public static String addBinary(String a, String b) {
        int flag = 0;
        int max = Math.max(a.length(), b.length());
        char[] ret = new char[max + 1];
        for(int i = a.length() - 1,j = b.length() - 1;i >= 0 || j >= 0; i--,j--){
            int t = flag;
            if(i >= 0){
                t += (a.charAt(i) - '0');
            }
            if(j >= 0){
                t += (b.charAt(j) - '0');
            }
            flag = t / 2;
            ret[max--] = (t % 2 == 0 ? '0' : '1');
        }
        if(flag > 0) ret[max--] = '1';
        return new String(ret,1 - flag,ret.length + flag -1);
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        System.out.println(addBinary(a, b));
    }
}
