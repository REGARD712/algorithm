/**
 * https://leetcode.cn/problems/minimum-falling-path-sum/
 *
 * @ClassName: MinFallingPathSum
 * @Author: JacksonLee
 * @Date: 2026/10/27
 */
public class MinFallingPathSum {

    /**
     * 空间优化版本动态规划
     *
     * @param matrix
     * @return int
     */
    public int minFallingPathSum(int[][] matrix) {
        // 预处理
        int m = matrix.length, n = matrix[0].length;

        // 创建dp表:第0列和第n+1列初始化为正无穷大
        int[] dp = new int[n+2];
        dp[0] = dp[n+1] = Integer.MAX_VALUE;
        // dp[1..n] 默认 0，代表虚拟第 0 行

        // 从上往下、从左往右填dp表
        for (int i = 1; i <= m; i++) {
            int prev = dp[0];         // dp[i-1][j-1]
            for (int j = 1; j <= n; j++) {
                int cur = dp[j];         // dp[i-1][j]
                dp[j] = Math.min(prev, Math.min(dp[j], dp[j+1])) + matrix[i-1][j-1];
                // 继续下一行滚动时先将prev改为dp[i][j],对于下一行就是dp[i-1][j-1]
                prev = cur;
            }
        }

        // 扫描最后一行,找到最小值
        int ans = dp[0];
        for (int j = 1; j <= n; j++) {
            ans = Math.min(ans, dp[j]);
        }

        // 返回结果
        return ans;
    }

    /**
     * 普通动态规划
     *
     * @param matrix
     * @return int
     */
    public int minFallingPathSum2(int[][] matrix) {
        // 预处理
        int m = matrix.length, n = matrix[0].length;

        // 创建dp表:第0列和第n+1列初始化为正无穷大
        int[][] dp = new int[m+1][n+2];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i][n+1] = Integer.MAX_VALUE;
        }

        // 初始化:将第0行初始化为0
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        // 从上往下、从左往右填dp表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1])) + matrix[i-1][j-1];
            }
        }

        // 扫描最后一行,找到最小值
        int ans = dp[m][0];
        for (int j = 1; j <= n; j++) {
            ans = Math.min(ans, dp[m][j]);
        }

        // 返回结果
        return ans;
    }
}
