package leetcode.algorithm.section3;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * 0 <= x <= 2^31 - 1
 */
public class Solution69 {
    public static int mySqrt(int x) {
        if(x==0 || x==1) return x;
        long t2 = x;
        long start = 1;
        long end = x;
        while (true){
            if(start + 1 == end){
                if(end * end > t2){
                    return (int)start;
                }else {
                    return (int)end;
                }
            }
            long mid = (end + start) / 2;
            if(mid * mid > t2){
                end = mid;
            }else if(mid * mid == t2){
                return (int)mid;
            }else {
                start = mid;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }
}
