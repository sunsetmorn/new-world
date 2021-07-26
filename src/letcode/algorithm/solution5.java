package letcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class solution5 {
    private char[] chars;
    /**
     * 以回文子串的中间为基点，两边对称数的位数相加为中间数的
     *
     */
//    public static String longestPalindrome(String s){
//        int a=0,b=0,length=0;
//
//    }
    /**
     * 408 ms
     * 38.8 MB
     */
    public String longestPalindrome2(String s) {
        if(s.length() ==0) return "";
        int left=0,right=0,length=0;
        chars = s.toCharArray();
        for(int i=-1;i < chars.length-1; i++){
            for(int j=chars.length-1;j > i; j--){
                if(s.length() - i+1 <length){break;}
                if(isPalindrome(i+1,j+1)){
                    if (j-i >length){
                        length = j-i;
                        left=i+1;
                        right=j+1;
                    }
                }
            }
        }
        return s.substring(left,right);
    }

    /**
     * 字符是否回文
     * return boolean
     */
    public boolean isPalindrome(int a,int b){
        for(int i=a;i<b;i++){
            if(chars[i] !=chars[b-i+a-1]){
                return false;
            }
        }
        return true ;
    }

    public static boolean isPalindrome(String str){
        if (str.isEmpty()) return true;
        for(int i =0;i <= str.length()/2;i++){
            if(str.charAt(i) !=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a ="a";
//        String b = longestPalindrome2(a);
//        System.out.println(b);
    }
}
