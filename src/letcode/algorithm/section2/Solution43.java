package letcode.algorithm.section2;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 */
public class Solution43 {
    public static String multiply(String num1, String num2) {
        if(num1.length() == 0 || num2.length() == 0) return null;
        if("0".equals(num1) || "0".equals(num2)) return "0";
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        char[] chars = new char[chars1.length + chars2.length];
        int[] ints = new int[chars.length];
        for(int i = 0 ; i < chars1.length ; i++){
            for(int j = 0; j < chars2.length ; j++){
                ints[i+j+1] += (chars1[i]-48) * (chars2[j]-48);
            }
        }
        for(int i = ints.length -1 ; i >= 0 ; i-- ){
            chars[i] = String.valueOf(ints[i] % 10).toCharArray()[0];
            if(i != 0){
                ints[i-1] += ints[i] / 10 ;
            }
        }
        return chars[0] == '0' ? String.valueOf(chars,1,chars.length-1) : String.valueOf(chars).trim();
    }

    public static void main(String[] args) {
        String a = "896515113";
        String b = "456";
        System.out.println(0*456);
        String multiply = multiply(a, b);
        System.out.println(multiply);
    }

}
