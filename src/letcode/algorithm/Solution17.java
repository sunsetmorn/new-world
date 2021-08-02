package letcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * �绰�������ĸ���
 */
public class Solution17 {
    /**
     * ִ����ʱ��0 ms, ������ Java �ύ�л�����100.00%���û�
     * �ڴ����ģ�38.3 MB, ������ Java �ύ�л�����30.13%���û�
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
     * ִ����ʱ��1 ms, ������ Java �ύ�л�����79.05%���û�
     * �ڴ����ģ�38.6 MB, ������ Java �ύ�л�����21.18%���û�
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
