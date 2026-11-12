/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @ClassName: MaxProfit
 * @Author: JacksonLee
 * @Date: 2026/11/12
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

        // 创建两个状态表
        // unavail[i][j]表示第i天结束时处于"买入"状态且已交易j笔交易的最大利润
        int[][] unavail = new int[n][3];
        // avail[i][j]表示第i天结束时处于"可交易"状态且已交易j笔交易的最大利润
        int[][] avail = new int[n][3];

        // 初始化
        // 第一天结束时处于"买入"状态且交易0笔的最大利润为-prices[0]
        unavail[0][0] = -prices[0];
        // 第一天结束时不可能已交易1笔或2笔交易,为防止干扰填表初始化为负无穷的一半
        unavail[0][1] = unavail[0][2] = avail[0][1] = avail[0][2] = -0x3f3f3f3f;

        // 从左往右、从上往下填表
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                unavail[i][j] = Math.max(unavail[i-1][j], avail[i-1][j]-prices[i]);
                avail[i][j] = avail[i-1][j];
                if (j-1 >= 0) {
                    avail[i][j] = Math.max(avail[i][j], unavail[i-1][j-1]+prices[i]);
                }
            }
        }

        // 返回结果:"可交易"表avail最后一行的最大值
        int ans = avail[n-1][0];
        for (int j = 1; j < 3; j++) {
            ans = Math.max(ans, avail[n - 1][j]);
        }
        return ans;
    }
}
