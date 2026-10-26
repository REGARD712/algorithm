/**
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @ClassName: JewelleryValue
 * @Author: JacksonLee
 * @Date: 2026/10/26
 */
public class JewelleryValue {

    /**
     * 空间优化版本动态规划
     *
     * @param frame
     * @return int
     */
    public int jewelleryValue(int[][] frame) {
        // 预处理
        int m = frame.length, n = frame[0].length;

        // 创建dp表
        int[] dp = new int[n+1];

        // 填dp表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j-1], dp[j]) + frame[i-1][j-1];
            }
        }

        // 返回结果
        return dp[n];
    }

    /**
     * 普通版本动态规划
     *
     * @param frame
     * @return int
     */
    public int jewelleryValue2(int[][] frame) {
        // 预处理
        int m = frame.length, n = frame[0].length;

        // 创建dp表
        int[][] dp = new int[m+1][n+1];

        // 填dp表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + frame[i-1][j-1];
            }
        }

        // 返回结果
        return dp[m][n];
    }
}
