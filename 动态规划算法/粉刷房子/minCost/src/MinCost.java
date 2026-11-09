/**
 * https://leetcode.cn/problems/JEj789/
 *
 * @ClassName: MinCost
 * @Author: JacksonLee
 * @Date: 2026/11/9
 */
public class MinCost {

    /**
     * 多状态dp
     *
     * @param costs 每个房子的三种颜色的花费
     * @return int
     */
    public int minCost(int[][] costs) {
        // 预处理
        int n = costs.length;

        // 创建dp表:dp[i][0]/dp[i][1]/dp[i][2]表示粉刷第i个房子时粉刷成红色/蓝色/绿色
        int[][] dp = new int[n+1][3];

        // 从左往右填dp表
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i-1][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i-1][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i-1][2];
        }

        // 返回结果:最后一个位置三种情况的较小值
        return Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
    }
}
