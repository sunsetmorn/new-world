package leetcode.algorithm.section2;

import java.util.*;

/**
 * 给你一个字符串数组，请你将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */

public class Solution49 {
    /**
     * 使用Map来存取，key是经过排序的字符串，使用getOrDefault方法来处理空值情况，最后map转list返回
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
