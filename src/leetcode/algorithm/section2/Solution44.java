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
    public boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty()) return true;
        if(s.equals(p)) return true;
        if(p.isEmpty() && !s.isEmpty()) return false;
        boolean[][] booleans = new boolean[s.length()+1][p.length()+1];
        booleans[0][0] = true;



        return false;
    }
}