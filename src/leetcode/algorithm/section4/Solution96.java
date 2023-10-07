package leetcode.algorithm.section4;

/**
 * @author zhaoxq
 * @ClassName Solution96
 * @description:
 * @date 2023年09月26日
 */

/**
 * 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * 提示
 * 1 <= n <= 19
 */
public class Solution96 {
    /**
     * 1个数字的二叉树个数 = 左边0个数字的二叉树个数 * 右边0个数字的二叉树个数
     * 2个数字的二叉树个数 = 左边1个数字的二叉树个数 * 右边0个数字的二叉树个数 + 左边0个数字的二叉树个数 * 右边1个数字的二叉树个数
     * 。。。
     *
     * 递推计算：
     * f(0) = 1;
     * f(1) = f(0) * f(0) = 1;
     * f(2) = f(0) * f(1) + f(1) * f(0) = 2;
     * f(3) = f(0) * f(2) + f(1) * f(1) + f(0) * f(2) = 5;
     * f(4) = f(0) * f(3) + f(1) * f(2) + f(2) * f(1) + f(3) * f(0)= 14;
     * 。。。
     */
    public static int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] += nums[j] * nums[i - j - 1];
            }
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(7));
    }


}
