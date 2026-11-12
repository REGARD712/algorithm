/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @ClassName: MaxProfit
 * @Author: JacksonLee
 * @Date: 2026/11/12
 */
public class MaxProfit {

    /**
     * 多状态dp
     *
     * @param k 最大交易次数
     * @param prices 股票价格数组,prices[i]表示第i天股票的价格
     * @return int
     */
    public int maxProfit(int k, int[] prices) {
        // 预处理
        int n = prices.length;

        // 创建两个状态表
        // unavail[i][j]表示第i天结束时处于"买入"状态且已交易j笔交易的最大利润
        int[][] unavail = new int[n][k+1];
        // avail[i][j]表示第i天结束时处于"可交易"状态且已交易j笔交易的最大利润
        int[][] avail = new int[n][k+1];

        // 初始化
        // 第一天结束时处于"买入"状态且交易0笔的最大利润为-prices[0]
        unavail[0][0] = -prices[0];
        // 第一天结束时不可能已交易>=1笔交易,为防止干扰填表初始化为负无穷的一半
        for (int j = 1; j <= k; j++) {
            unavail[0][j] = avail[0][j] = -0x3f3f3f3f;
        }

        // 从左往右、从上往下填表
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                unavail[i][j] = Math.max(unavail[i-1][j], avail[i-1][j]-prices[i]);
                avail[i][j] = avail[i-1][j];
                if (j-1 >= 0) {
                    avail[i][j] = Math.max(avail[i][j], unavail[i-1][j-1]+prices[i]);
                }
            }
        }

        // 返回结果:"可交易"表avail最后一行的最大值
        int ans = avail[n-1][0];
        for (int j = 1; j <= k; j++) {
            ans = Math.max(ans, avail[n-1][j]);
        }
        return ans;
    }
}
