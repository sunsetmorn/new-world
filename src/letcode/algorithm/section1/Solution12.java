package letcode.algorithm.section1;

/**
 * 数字转罗马字符
 */
public class Solution12 {
    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：37.8 MB, 在所有 Java 提交中击败了66.81%的用户
     */
    public static String intToRoman(int num) {
        StringBuffer s =new StringBuffer();
        if(num > 3999) return null;
        int[] nums =new int[]{10000,1000,100,10,1,1};
        char[] chara =new char[]{' ','M','C','X','I'};
        char[] charb =new char[]{' ','D','L','V'};
        for(int i=0;i<4;i++){
            if(num%nums[i] >=9*nums[i+1]){
                s.append(chara[i+1]).append(chara[i]);
            }else if(num%nums[i] >=5*nums[i+1]){
                s.append(charb[i]);
                for(int j=0;j<(num%nums[i]-5*nums[i+1])/nums[i+1];j++){
                    s.append(chara[i+1]);
                }
            }else if(num%nums[i] >=4*nums[i+1]){
                s.append(chara[i+1]).append(charb[i]);
            }else{
                for(int j=0;j<(num%nums[i])/nums[i+1];j++){
                    s.append(chara[i+1]);
                }
            }
        }
        return s.toString();
    }
    /**
     * leetcode最短时间算法。
     */
    public String intToRoman1(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                sb.append(rom[i]);
                num-=values[i];
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int a =1998;
        String b =intToRoman(a);
        System.out.println(b);
    }
}
