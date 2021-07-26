package letcode.algorithm;

import java.util.*;
/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution3 {
    /**
     * 执行用时：129 ms
     * 内存消耗：38.7 MB
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() ==0) return 0;
        int retLen = 1;
        for(int i = 0; i < s.length(); i++){
            if (retLen >= s.length() -i) break;
            Set<Character> tmpset =new HashSet<>();
            for(int j = i; j < s.length();j++){
                if(tmpset.contains(s.charAt(j))){
                    retLen = retLen > j-i?retLen:j-i;
                    break;
                }else if(j == s.length() -1){
                    retLen = retLen > j-i+1?retLen:j-i+1;
                    break;
                }else {
                    tmpset.add(s.charAt(j));
                }
            }
        }
        return retLen;
    }

    /**
     * 执行用时：8 ms
     * 内存消耗：38.5 MB
     */
    public static int lengthOfLongestSubstring2(String s) {
        if(s.length() ==0) return 0;
        Set<Character> tmpSet =new HashSet<>();
        int left=0,right=0,length=0;
        while(right<s.length()){
            if(tmpSet.contains(s.charAt(right))){
                tmpSet.remove(s.charAt(left++));
                if(length > s.length()-left) break;
            }else{
                tmpSet.add(s.charAt(right++));
            }
            length = tmpSet.size()>length ? tmpSet.size():length;
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "aasdaegethyhafwr2rhuihfnjgkiloi;op/[pu";
        int b = lengthOfLongestSubstring2(s);
        System.out.println(b);
    }
}
