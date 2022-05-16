package leetcode.algorithm.section1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'?的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 */
public class Solution20 {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了73.40%的用户
     * 内存消耗：36.1 MB, 在所有 Java 提交中击败了97.79%的用户
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
     * 可扩展性算法
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
        //入栈
        public void push(int n){
            list.add(n);
            index++;
        }
        //出栈
        public void pop(){
            if(!list.isEmpty()){
                index--;
                list.remove(index);
            }
        }
        //取栈顶元素
        public int get(){
            return list.get(index-1);
        }
        //是否为空
        public boolean empty(){
           return index == 0;
        }
    }

    public static void main(String[] args) {
        String a = "()";

        System.out.println(isValid1(a));
    }
}
