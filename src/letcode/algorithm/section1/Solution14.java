package letcode.algorithm.section1;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 */
public class Solution14 {
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了81.29%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了82.51%的用户
     */
    public static String longestCommonPrefix(String[] strs) {
        int min = 200;
        int k = 0;
        boolean flag =true;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length() < min){
                min = strs[i].length();
            }
        }
        for(int i=0;i<min;i++){
            for(int j=0;j<strs.length;j++){
                if(j==0) {
                    continue;
                }else {
                    if(strs[j].charAt(i) ==strs[j-1].charAt(i)){
                        continue;
                    }else{
                        flag =false;
                        break;
                    }
                }
            }
            if(!flag){
                break;
            }else{
                k++;
            }
        }
        return strs[0].substring(0,k);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        String a =longestCommonPrefix(strs);
        System.out.println(a);
    }

    /**
     *  leetcode最短时间解
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}

