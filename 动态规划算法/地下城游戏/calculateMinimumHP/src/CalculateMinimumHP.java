/**
 * https://leetcode.cn/problems/dungeon-game/
 *
 * @ClassName: CalculateMinimumHP
 * @Author: JacksonLee
 * @Date: 2026/10/29
 */
public class CalculateMinimumHP {
    /**
     * 普通状态规划
     *
     * @param dungeon 地下城地图
     * @return int
     */
    public int calculateMinimumHP(int[][] dungeon) {
        // 预处理
        int m = dungeon.length, n = dungeon[0].length;

        // 创建dp表:dp[i][j]表示从[i,j]位置出发到达终点时的最低初始健康点数
        int[][] dp = new int[m+1][n+1];

        // 初始化
        // 把最后一行和最后一列初始化为正无穷
        for (int j = 0; j <= n; j++) {
            dp[m][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }
        // 将右下角格子的左格子和上格子初始化为1
        dp[m][n-1] = dp[m-1][n] = 1;

        // 从下往上、从右往左填dp表
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                // 求出dp[i][j]后,要防止健康点数为零或负数
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
            }
        }

        // 返回结果:dp[0][0]
        return dp[0][0];
    }
}
