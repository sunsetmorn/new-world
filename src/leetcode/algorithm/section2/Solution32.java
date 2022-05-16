package leetcode.algorithm.section2;

/**
 * ����һ��ֻ���� '(' �� ')' ���ַ������ҳ����Ч����ʽ��ȷ�������������Ӵ��ĳ��ȡ�
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
     * leetcode���ʱ���㷨
     * ���ַ����ڶ�λ��ʼ��������ÿ��λ��Ϊ��������Ч�����ַ���������ֵ������һ������dp����¼��Ч���ȡ�������0��ʾ����Ч�ַ���0��ʾ����Ϊ0��
     * �жϸ�λ���Ƿ�Ϊ�������������һ���жϣ��ж����ݸ��������������
     * 1.��������ǰһλ����ǡ����������Ȼ��ƥ��ġ��������Ч�ַ�������2��
     * 2.��ĩβ������ƥ��ġ�������Ȼ�������Ч�ַ�����ͷ�����ڲ���Ч�ַ���ǰһλ�����ĩβ��i,�ڲ���Ч�ַ�������dp[i-1],ǰһλ��i-dp[i-1]-1����
     * 3.��Ч�ַ���+��Ч�ַ���������Ч�ַ�������ʱ���һλ�����Ǻϲ���������Ч�ַ��ĳ��ȡ�
     * ������Щ���ɿ��Եõ���ǰλ�ó�����ֵ��֮ǰλ�ó�����ֵ�Ĺ�ϵ��
     * �����λ�ò��ǡ���������Ҫ����
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
