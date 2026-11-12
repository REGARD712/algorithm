/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 *
 * @ClassName: MaxProfit
 * @Author: JacksonLee
 * @Date: 2026/11/12
 */
public class MaxProfit {

    /**
     * 多状态dp
     *
     * @param prices
     * @param fee
     * @return int
     */
    public int maxProfit(int[] prices, int fee) {
        // 预处理
        int n = prices.length;

        // 创建状态表
        // avail[i]表示当天结束处于可交易状态的最大利润
        int[] avail = new int[n];
        // unavail[i]表示当天结束处于买入股票状态的最大利润
        int[] unavail = new int[n];

        // 初始化
        unavail[0] = -prices[0];

        // 从左往右填表
        for (int i = 1; i < n; i++) {
            avail[i] = Math.max(avail[i-1], unavail[i-1]+prices[i]-fee);
            unavail[i] = Math.max(unavail[i-1], avail[i-1]-prices[i]);
        }

        // 返回结果
        return Math.max(avail[n-1], unavail[n-1]);
    }
}
