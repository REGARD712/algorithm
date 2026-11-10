/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * @ClassName: MaxProfit
 * @Author: JacksonLee
 * @Date: 2026/11/10
 */
public class MaxProfit {

    /**
     * 多状态dp
     *
     * @param prices 股票价格数组
     * @return int
     */
    public int maxProfit(int[] prices) {
        // 预处理
        int n = prices.length;

        // 创建dp表(dp[i][0]表示"买入",dp[i][1]表示"可交易",dp[i][2]表示"冷冻期")
        int[][] dp = new int[n][3];

        // 初始化:dp[0][0]=-prices[0];dp[0][1]=dp[0][2]=0
        dp[0][0] = -prices[0];

        // 从左往右填dp表
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2]);
            dp[i][2] = dp[i-1][0] + prices[i];
        }

        // 返回结果:最后一天处于"可交易"状态和"冷冻期"状态的较大值
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}
