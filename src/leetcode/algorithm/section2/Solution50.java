package leetcode.algorithm.section2;

/**
 * 实现 pow(x,n) ，即计算x的整数n次幂函数（即，x^n）
 *
 * 提示:
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * n是一个整数
 * 要么x不为零，要么 n > 0 。
 * -10^4 <= x^n <= 10^4
 *
 */
public class Solution50 {
    /**
     *  对指数的范围进行扩增，变量存放内存放大，避免边界计算异常。
     *  指数为正直接取下面计算结果，指数为负取倒数。
     *  指数按照绝对值进行下面计算
     *  指数对2取余，
     *      余数为0，可以把底数变为平方，指数除二
     *      余数不为0，将底数单独拿出来和，乘到结果中
     */
    public static double myPow(double x, int n) {
        double ans = 1;
        long N = Math.abs((long)n);
        while (N > 0)
        {
            if (N % 2 != 0){
                ans *= x;
            }
            N /= 2;
            x *= x;
        }
        return n > 0? ans : 1.0 / ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,100));
    }
}
