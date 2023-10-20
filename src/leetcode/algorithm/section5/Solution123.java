package leetcode.algorithm.section5;

/**
 * @author zhaoxq
 * @ClassName Solution123
 * @description:
 * @date 2023年10月19日
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 提示：
 * 1 <= prices.length <= 100000
 * 0 <= prices[i] <= 100000
 */

public class Solution123 {

    public static int maxProfit(int[] prices) {
        int ret = 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        if(prices.length != 1){
            int buy = prices[0];
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max = Math.max(prices[i] - buy,max);
                buy = Math.min(buy,prices[i]);
                left[i] = max;
            }
            max = 0;
            int sale = prices[prices.length - 1];
            for (int i = prices.length - 2; i >= 0; i--) {
                max = Math.max(sale - prices[i],max);
                sale = Math.max(sale,prices[i]);
                right[i] = max;
            }
            for (int i = 0; i < prices.length; i++) {
                ret = Math.max(left[i] + right[i],ret);
            }
        }
        return ret;
    }

    public int maxProfit2(int[] prices) {
        // DP 确定状态转移方程
        // buy1 第一次买        max{buy1, -price[i]}
        // sell1 完成第一次交易 max{sell1, buy1+price[i]}
        // buy2 第二次买        max{buy2, sell1-price[i]}
        // sell2 完成第二笔交易 max{sell2, buy2+price[i]}
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1-prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    public static void main(String[] args) {
        int[] a = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(a));
    }
}
