/**
 * https://leetcode.cn/problems/minimum-path-sum/
 *
 * @ClassName: MinPathSum
 * @Author: JacksonLee
 * @Date: 2026/10/28
 */
public class MinPathSum {

    /**
     * 普通动态规划
     *
     * @param grid 输入的网格
     * @return int
     */
    public int minPathSum(int[][] grid) {
        // 预处理
        int m = grid.length, n = grid[0].length;

        // 创建dp表
        int[][] dp = new int[m+1][n+1];

        // 初始化:将第0行中下标j>=2和第0列中下标i>=2的值都改为无穷大
        for (int j = 2; j <= n; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= m; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        // 从上往下、从左往右填dp表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }

        // 返回结果
        return dp[m][n];
    }
}
