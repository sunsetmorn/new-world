package leetcode.algorithm.section2;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class Solution32 {
    public static int longestValidParentheses(String s) {
        if(s.isEmpty()) return 0;
        int length = 0;
        int[] index = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(i==0){
                    index[i]=1;
                }else{
                    index[i]=index[i-1] +1;
                }
            }else{
                if(i==0){
                    index[i]=-1;
                }else{
                    index[i]=index[i-1] -1;
                }
            }
        }
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){
                int level =index[i]-1;
                int tmpLength = 1;
                for(int j=i+1;j<s.length();j++){
                    if(index[j] >level) {
                        tmpLength++;
                    }else if (index[j] == level){
                        tmpLength++;
                        length = tmpLength > length ? tmpLength:length;
                    }else{
                        break;
                    }
                }
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String a="((((())))(())()()()))(())(())";
        int t =longestValidParentheses(a);
        System.out.println("44644545"+t);
    }

    /**
     * leetcode最短时间算法
     * 从字符串第二位开始，计算以每个位置为结束的有效括号字符串长度数值。设立一个数组dp，记录有效长度。（大于0表示是有效字符，0表示长度为0）
     * 判断该位置是否为“）”，是则进一步判断，判断内容根据下面规律来：
     * 1.“）”的前一位如果是“（”，则必然是匹配的。且最短有效字符长度是2。
     * 2.与末尾“）”匹配的“（”必然在最短有效字符串开头，即内部有效字符的前一位（如果末尾是i,内部有效字符长度是dp[i-1],前一位是i-dp[i-1]-1）。
     * 3.有效字符串+有效字符串还是有效字符串，此时最后一位长度是合并和整体有效字符的长度。
     * 根据这些规律可以得到当前位置长度数值和之前位置长度数值的关系。
     * 如果该位置不是“）”则不需要处理。
     *
     */
    public int longestValidParentheses1(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i == 1) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 2] + 2;
                    }
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] - 1 == 0) {
                        dp[i] = dp[i - 1] + 2;
                    } else {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
