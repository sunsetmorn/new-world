package letcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��Ч������
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'?���ַ��� s ���ж��ַ����Ƿ���Ч��
 * ��Ч�ַ��������㣺
 * 1.�����ű�������ͬ���͵������űպϡ�
 * 2.�����ű�������ȷ��˳��պϡ�
 */
public class Solution20 {
    /**
     * ִ����ʱ��2 ms, ������ Java �ύ�л�����73.40%���û�
     * �ڴ����ģ�36.1 MB, ������ Java �ύ�л�����97.79%���û�
     */
    public static boolean isValid(String s) {
        Stack mid = new Stack();
        for (int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                mid.push(1);
            }else if(s.charAt(i)=='{'){
                mid.push(2);
            }else if(s.charAt(i)=='['){
                mid.push(3);
            }else if(s.charAt(i)==')'){
                if(!mid.empty() && mid.get() == 1){
                    mid.pop();
                }else{
                    return false;
                }
            }else if(s.charAt(i)=='}'){
                if(!mid.empty() && mid.get() == 2){
                    mid.pop();
                }else{
                    return false;
                }
            }else if(s.charAt(i)==']'){
                if(!mid.empty() && mid.get() == 3){
                    mid.pop();
                }else{
                    return false;
                }
            }
        }
        return mid.empty();
    }

    /**
     * ����չ���㷨
     *
     */
    public static boolean isValid1(String s){
        Stack mid = new Stack();
        Map rule = new HashMap();
        rule.put('(',1);
        rule.put('{',2);
        rule.put('[',3);
        rule.put(')',-1);
        rule.put('}',-2);
        rule.put(']',-3);
        for (int i = 0;i<s.length();i++){
            for (Object a:rule.keySet()) {
                if((char)a ==s.charAt(i)){
                    if((int)rule.get(a) > 0){
                        mid.push((int)rule.get(a));
                    }else if((int)rule.get(a) < 0){
                        if(mid.empty()) return false;
                        if(mid.get() + (Integer) rule.get(a) ==0){
                            mid.pop();
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return mid.empty();
    }

    static class Stack {
        List<Integer> list = new ArrayList<Integer>();
        int index = 0;
        //��ջ
        public void push(int n){
            list.add(n);
            index++;
        }
        //��ջ
        public void pop(){
            if(!list.isEmpty()){
                index--;
                list.remove(index);
            }
        }
        //ȡջ��Ԫ��
        public int get(){
            return list.get(index-1);
        }
        //�Ƿ�Ϊ��
        public boolean empty(){
           return index == 0;
        }
    }

    public static void main(String[] args) {
        String a = "()";

        System.out.println(isValid1(a));
    }
}
