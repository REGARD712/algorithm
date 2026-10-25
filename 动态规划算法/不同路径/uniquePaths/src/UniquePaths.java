/**
 * https://leetcode.cn/problems/unique-paths/
 *
 * @ClassName: UniquePaths
 * @Author: JacksonLee
 * @Date: 2026/10/22
 */
public class UniquePaths {

    /**
     * 空间优化版本动态规划
     * @param m
     * @param n
     * @return int
     */
    public int uniquePaths(int m, int n) {
        // 一维数组：dp[j] 在更新前代表"上一行"的 dp[i-1][j]
        //                 更新后代表"当前行"的 dp[i][j]
        int[] dp = new int[n + 1];

        // 对应原来的 dp[0][1] = 1（第0行第1列为1，充当"起点上方"的虚拟值）
        dp[1] = 1;

        // 从上往下、从左往右滚动
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n];   // 循环结束时 dp[n] 就是 dp[m][n]
    }

    /**
     * 普通动态规划
     * @param m
     * @param n
     * @return int
     */
    public int uniquePaths2(int m, int n) {
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
