package leetcode.algorithm.section1;
/**
 * 回文整数
 */
public class Solution9 {
    //不转成字符串解
    public static boolean isPalindrome1(int x) {
        if(x<0) return false;
        if(x< 10) return true;
        int len =0;
        int y = x;
        int a[] = new int[32];
        while(y/10 >= 1){
            a[len++] = y%10;
            y = y/10;
        }
        a[len] = y;
        for(int i =0;i<(len+1/2);i++){
            if(a[i] != a[len-i]){
                return false;
            }
        }
        return true;
    }

//   使用字符串方法
    public static boolean isPalindrome(int x) {
        String a = String.valueOf(x);
        if(a.equals(new StringBuilder(a).reverse().toString())){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int a= 10;
        System.out.println(isPalindrome(a));
    }
}
