package letcode.algorithm.section1;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 */
public class Solution22 {
    /**
     * 执行用时：46 ms, 在所有 Java 提交中击败了5.11%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了41.80%的用户
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
     *  leetcode最短时间算法
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
            current.deleteCharAt(current.length() - 1); //去除字符串后方的所有")"后，去除最后一个"("
        }
        if(right < left) {
            current.append(')'); //去除字符串后方的所有")"后，去除最后一个"("后，添加一个")"
            backtrack(current, left, right + 1, n, resultList);
            current.deleteCharAt(current.length() - 1);  //去除字符串后方的所有")"
        }
    }

    public static void main(String[] args) {
        int a = 8;
        List<String> b = generateParenthesis(a);
        System.out.println(b);
    }
}
