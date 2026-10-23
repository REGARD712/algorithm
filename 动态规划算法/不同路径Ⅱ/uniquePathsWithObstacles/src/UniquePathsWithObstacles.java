/**
 * https://leetcode.cn/problems/unique-paths-ii/
 *
 * @ClassName: UniquePathsWithObstacles
 * @Author: JacksonLee
 * @Date: 2026/10/23
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 预处理
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // 创建dp表
        int[][] dp = new int[m+1][n+1];

        // 初始化
        dp[0][1] = 1;

        // 填dp表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i-1][j-1] == 0) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }

        // 返回结果
        return dp[m][n];
    }
}
