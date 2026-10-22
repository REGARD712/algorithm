/**
 * https://leetcode.cn/problems/unique-paths/
 *
 * @ClassName: UniquePaths
 * @Author: JacksonLee
 * @Date: 2026/10/22
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // 创建dp表(包含用于初始化的虚拟节点)
        int[][] dp = new int[m+1][n+1];

        // 初始化
        dp[0][1] = 1;

        // 从上往下、从左往右填表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        // 返回结果,到达右下角的路径数dp[m][n]
        return dp[m][n];
    }
}
