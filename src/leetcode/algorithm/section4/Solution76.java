package leetcode.algorithm.section4;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 提示：
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 */
public class Solution76 {
    public static String minWindow(String s, String t) {
        int[] sMap = new int[128];
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int start = 0,end = 0,invalid = 0,flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if(need[s.charAt(i)] > 0){
                if(invalid < t.length()){
                    for(int j = Math.max(flag,i); j < s.length(); j++){
                        int tmp2 = s.charAt(j);
                        if(need[tmp2] > 0){
                            sMap[tmp2]++;
                            if(sMap[tmp2] <= need[tmp2]){
                                invalid++;
                            }
                        }
                        if(invalid == t.length()){
                            flag = j + 1;
                            break;
                        }
                    }
                }
                if(invalid == t.length()){
                    if(end == 0 || flag - i < end - start){
                        start = i;
                        end = flag;
                    }
                    sMap[s.charAt(i)]--;
                    if(sMap[s.charAt(i)] < need[s.charAt(i)]){
                        invalid--;
                    }
                }else {
                    break;
                }
            }
        }
        if(end == 0) return "";
        return s.substring(start,end);
    }

    public String minWindow2(String s, String t) {
        int n = s.length();
        int[] need = new int[128];
        //Map<Character,Integer> need = new HashMap<>();
        for(int a = 0;a < t.length();a++){
            need[t.charAt(a)]++;
        }
        int count = t.length();
        int res = Integer.MAX_VALUE;
        int begin = 0;

        int i = 0,j = 0;
        while(j < n){
            if(need[s.charAt(j)] > 0){
                count--;
            }
            need[s.charAt(j)]--;
            if(count == 0){
                while(i < j && need[s.charAt(i)] < 0){
                    need[s.charAt(i)]++;
                    i++;
                }
                if(res > j - i + 1){
                    res = j - i + 1;
                    begin = i;
                }
                need[s.charAt(i)]++;
                i++;
                count++;
            }
            j++;
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(begin,begin + res);
    }

    public static void main(String[] args) {
        String a = "";
        String b = "";
        String s = minWindow(a, b);
        System.out.println(s);
    }
}
