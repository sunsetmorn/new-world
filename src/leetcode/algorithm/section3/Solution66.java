package leetcode.algorithm.section3;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class Solution66 {
    public static int[] plusOne(int[] digits) {
        int[] plus = plus(digits, digits.length - 1);
        return plus;
    }

    private static int[] plus(int[] a,int f){
        if(a[f] == 9){
            a[f] = 0;
            if(f > 0){
                return plus(a, f - 1);
            }else {
                int[] b = new int[a.length + 1];
                b[0] = 1;
                return b;
            }
        }else {
            a[f]++;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {9,9};
        int[] ints = plusOne(a);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}
