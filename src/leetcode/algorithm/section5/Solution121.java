package leetcode.algorithm.section5;

/**
 * @author zhaoxq
 * @ClassName Solution121
 * @description:
 * @date 2023年10月19日
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 提示：
 * 1 <= prices.length <= 100000
 * 0 <= prices[i] <= 10000
 */

public class Solution121 {
    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            ret = Math.max(prices[i] - buy,ret);
            buy = Math.min(buy,prices[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
