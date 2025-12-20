public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // 预处理dp表
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;    // 初始化边界条件，防止越界访问
        // 根据状态转移方程填写dp表
        for (int i = 2; i <= n; i ++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        // 返回结果
        return dp[n];
    }
}
