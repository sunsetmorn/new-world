package leetcode.algorithm.section2;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 */
public class Solution38 {
    public static String countAndSay(int n) {
        if(n<=0) return null ;
        String start ="1";
        if(n==1) return start;
        for(int i=1;i<n;i++){
            start =getNextOne(start);
        }
        return start;
    }

    public static String getNextOne(String str){
        StringBuilder stb = new StringBuilder();
        for(int i=0;i < str.length();i++){
            if(i+1<str.length() && str.charAt(i)==str.charAt(i+1)){
                if(i+2<str.length() && str.charAt(i)==str.charAt(i+2)){
                    stb.append("3").append(str.charAt(i));
                    i+=2;
                }else{
                    stb.append("2").append(str.charAt(i));
                    i++;
                }
            }else{
                stb.append("1").append(str.charAt(i));
            }
        }

        return stb.toString();
    }

    public static void main(String[] args) {
        String s = countAndSay(6);
        System.out.println(s);
    }
}
