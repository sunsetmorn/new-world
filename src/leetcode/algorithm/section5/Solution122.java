package leetcode.algorithm.section5;

/**
 * @author zhaoxq
 * @ClassName Solution122
 * @description:
 * @date 2023年10月19日
 *
 * 给你一个整数数组prices，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有一股股票。你也可以先购买，然后在同一天出售。
 * 返回你能获得的最大利润 。
 *
 * 1 <= prices.length <= 3 * 10000
 * 0 <= prices[i] <= 10000
 */

public class Solution122 {
    public int maxProfit(int[] prices) {
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]){
                ret += prices[i] - prices[i - 1];
            }
        }
        return ret;
    }
}
