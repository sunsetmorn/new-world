package leetcode.algorithm.section2;

import java.util.*;

/**
 * ����һ���ַ������飬���㽫��ĸ��λ�������һ�𡣿��԰�����˳�򷵻ؽ���б�
 * ��ĸ��λ��������������Դ���ʵ�������ĸ�õ���һ���µ��ʡ�
 *
 * ��ʾ��
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] ������Сд��ĸ
 */

public class Solution49 {
    /**
     * ʹ��Map����ȡ��key�Ǿ���������ַ�����ʹ��getOrDefault�����������ֵ��������mapתlist����
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return null;
        Map<String,List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String sortedStr = new String(tmp);
            List<String> strings = strMap.getOrDefault(sortedStr,new ArrayList<>());
            strings.add(str);
            strMap.put(sortedStr,strings);
        }
        return new ArrayList<List<String>>(strMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"a"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + ",");
            }
            System.out.println();
        }
    }
}
