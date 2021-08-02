package letcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class Solution17 {
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了30.13%的用户
     */
    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        char[][] a = new char[9][];
        a[0] = new char[]{};
        a[1] = new char[]{'a','b','c'};
        a[2] = new char[]{'d','e','f'};
        a[3] = new char[]{'g','h','i'};
        a[4] = new char[]{'j','k','l'};
        a[5] = new char[]{'m','n','o'};
        a[6] = new char[]{'p','q','r','s'};
        a[7] = new char[]{'t','u','v'};
        a[8] = new char[]{'w','x','y','z'};

        List<StringBuilder> l =new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            int v = Integer.parseInt(digits.substring(i,i+1));
            List<StringBuilder> tmp =new ArrayList<>();
            if(i==0){
                for(int j=0;j<a[v-1].length;j++){
                    StringBuilder ctmp = new StringBuilder();
                    ctmp.append(a[v-1][j]);
                    tmp.add(ctmp);
                }
            }else {
                for (int j = 0; j < a[v - 1].length; j++) {
                    for (int k = 0; k < l.size(); k++) {
                        StringBuilder dtmp = new StringBuilder();
                        tmp.add(dtmp.append(l.get(k).toString()).append(a[v - 1][j]));
                    }
                }
            }
            l = tmp;
        }
        for (int i =0;i<l.size();i++){
            ret.add(l.get(i).toString());
        }
        return ret;
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了79.05%的用户
     * 内存消耗：38.6 MB, 在所有 Java 提交中击败了21.18%的用户
     */
    public static List<String> letterCombinations1(String digits) {
        List<String> ret = new ArrayList<>();
        String[] a = {"","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<StringBuilder> l =new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            int v = Integer.parseInt(digits.substring(i,i+1));
            List<StringBuilder> tmp =new ArrayList<>();
            if(i==0){
                for(int j=0;j<a[v-1].length();j++){
                    StringBuilder ctmp = new StringBuilder();
                    ctmp.append(a[v-1].charAt(j));
                    tmp.add(ctmp);
                }
            }else {
                for (int j = 0; j < a[v - 1].length(); j++) {
                    for (int k = 0; k < l.size(); k++) {
                        StringBuilder dtmp = new StringBuilder();
                        tmp.add(dtmp.append(l.get(k).toString()).append(a[v - 1].charAt(j)));
                    }
                }
            }
            l = tmp;
        }
        for (int i =0;i<l.size();i++){
            ret.add(l.get(i).toString());
        }
        return ret;
    }

    public static void main(String[] args) {
        String a ="45";
        List<String> t = letterCombinations(a);
        for (int i=0;i<t.size();i++){
            System.out.println(t.get(i));
        }
    }
}
