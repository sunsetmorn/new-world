package letcode.algorithm;
/**
 *  罗马数字转整数
 */
public class Solution13 {
    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了65.05%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了33.91%的用户
     */
    public static int romanToInt(String s) {
        int[] values1={1000,500,50,5};
        int[] values2={100,10,1};
        int[] values3={900,400,90,40,9,4};
        char[] rom1={'M','D','L','V'};
        char[] rom2={'C','X','I'};
        String[] rom3={"CM","CD","XC","XL","IX","IV"};
        int ret =0;
        for2:for(int i=0;i < s.length(); i++){
            for(int j =0;j<rom1.length;j++){
                if(s.charAt(i)==rom1[j]){
                    ret+=(values1[j]);
                    continue for2;
                }
            }
            for1:for(int j =0;j<rom2.length;j++){
                if(s.charAt(i) == rom2[j]){
                    if(i+1 < s.length()){
                        for(int k =0;k<rom3.length;k++){
                            if(s.substring(i,i+2).equals(rom3[k])){
                                ret+=(values3[k]);
                                i++;
                                break for1;
                            }
                        }
                    }
                    ret+=(values2[j]);
                }
            }
        }
        return ret;
    }

    public static int romanToInt2(String s) {
        int result=getValue(s.charAt(s.length()-1));
        int num = result;
        for(int i=s.length()-2;i>=0;i--){
            int num1 = getValue(s.charAt(i));
            if(num1<num){
                result = result-num1;
            }else{
                result = result+num1;
            }
            num = num1;
        }
        return result;
    }

    public static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        String a="MCMXCIV";
        int c = romanToInt2(a);
        System.out.println(c);
    }
}
