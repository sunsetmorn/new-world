package letcode.algorithm.section2;

/**
 * 实现 strStr()
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 */
public class Solution28 {

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStr(String haystack, String needle) {
        if(needle==null || needle.isEmpty()) return 0;
        char[] sourceChars = haystack.toCharArray();
        char[] targetChars = needle.toCharArray();
        for(int i=0;i<sourceChars.length;i++){
            if(i+targetChars.length > sourceChars.length) return -1;
            if (sourceChars[i] == targetChars[0]) {
                if(targetChars.length ==1) return i;
                for(int j =1;j<targetChars.length;j++){
                    if(sourceChars[i+j] != targetChars[j]){
                        break;
                    }
                    if(j==targetChars.length-1){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a ="dgabkjabckj";
        String b ="kj";
        int k = strStr(a,b);
        System.out.println(k);
    }
}
