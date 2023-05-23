package leetcode.algorithm.section2;

import java.util.HashMap;

/**
 * ����һ���ַ��� (s) ��һ���ַ�ģʽ (p) ��ʵ��һ��֧�� '?' �� '*' ��ͨ���ƥ�䡣
 * '?' ����ƥ���κε����ַ���
 * '*' ����ƥ�������ַ������������ַ�������
 *
 * �����ַ�����ȫƥ�����ƥ��ɹ���
 * ˵��:
 * s����Ϊ�գ���ֻ������a-z��Сд��ĸ��
 * p����Ϊ�գ���ֻ������a-z��Сд��ĸ���Լ��ַ�?��*��
 *
 */
public class Solution44 {
    public static boolean isMatch(String s, String p) {
        System.out.println(s);
        System.out.println(p);
        if(s.isEmpty() && p.isEmpty()) return true;
        if(s.equals(p)) return true;
        if(p.isEmpty() && !s.isEmpty()) return false;
        if(!p.isEmpty() && s.isEmpty()){
            return p.replace("*","").length() ==0;
        }
        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'){
            return isMatch(s.substring(1),p.substring(1));
        }else if(p.charAt(0) == '*'){
            if(p.length() ==1) return true;
            for(int i =0;i < s.length();i++){
                if(isMatch(s.substring(i),p.substring(1))){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab","***bba**a*bbba**aab**b");
    }
}