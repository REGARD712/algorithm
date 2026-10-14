public class WaysToStep {
    public int waysToStep(int n) {
        // 边界情况
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        // dp表
        int[] dp = new int[n+1];

        // 初始化
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 填表
        int MOD = (int) 1e9 + 7;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i-1] + dp[i-2])%MOD + dp[i-3])%MOD;
        }

        // 返回结果
        return dp[n];
    }
}
