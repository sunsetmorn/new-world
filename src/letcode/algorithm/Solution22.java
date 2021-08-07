package letcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * ����n�����������ŵĶ������������һ�������������ܹ��������п��ܵĲ�����Ч��������ϡ�
 */
public class Solution22 {
    /**
     * ִ����ʱ��46 ms, ������ Java �ύ�л�����5.11%���û�
     * �ڴ����ģ�38.6 MB, ������ Java �ύ�л�����41.80%���û�
     */
    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i==1){
                ret.add("()");
            }else{
                ret = generate(ret);
            }
        }
        return ret;
    }
    public static List<String> generate(List<String> a){
        List<String> ret1 = new ArrayList<>();
        for (String s:a) {
            for(int i=0;i<s.length();i++){
                StringBuilder tmp = new StringBuilder();
                tmp.append(s, 0, i).append("()").append(s.substring(i));
                if(!ret1.contains(tmp.toString())){
                    ret1.add(tmp.toString());
                }
            }
        }
        return ret1;
    }

    /**
     *  leetcode���ʱ���㷨
     */
    public List<String> generateParenthesis1(int n) {
        List<String> resultList = new ArrayList<>();
        backtrack(new StringBuffer(), 0, 0, n, resultList);
        return resultList;
    }

    public void backtrack(StringBuffer current, int left, int right, int n, List<String> resultList) {
        if (current.length() == 2 * n) {
            resultList.add(current.toString());
            return;
        }

        if (left < n) {
            current.append('(');
            backtrack(current, left + 1, right, n, resultList);
            current.deleteCharAt(current.length() - 1); //ȥ���ַ����󷽵�����")"��ȥ�����һ��"("
        }
        if(right < left) {
            current.append(')'); //ȥ���ַ����󷽵�����")"��ȥ�����һ��"("�����һ��")"
            backtrack(current, left, right + 1, n, resultList);
            current.deleteCharAt(current.length() - 1);  //ȥ���ַ����󷽵�����")"
        }
    }

    public static void main(String[] args) {
        int a = 8;
        List<String> b = generateParenthesis(a);
        System.out.println(b);
    }
}
