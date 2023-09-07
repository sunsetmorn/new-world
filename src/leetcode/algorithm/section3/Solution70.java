package leetcode.algorithm.section3;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 提示：
 * 1 <= n <= 45
 */
public class Solution70 {
    public static int climbStairs(int n) {
        if( n == 1 || n == 2) return n;
        int[] ret = new int[n];
        ret[0] = 1;
        ret[1] = 2;
        for(int i = 2; i < n; i++){
            ret[i] = ret[i - 1] + ret[i - 2];
        }
        return ret[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(30));
    }
}
