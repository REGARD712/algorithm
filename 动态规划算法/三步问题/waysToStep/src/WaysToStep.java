public class WaysToStep {
    public int waysToStep(int n) {
        // 处理边界情况
        if (n == 1 || n == 2) return n;
        if (n == 3) return 4;

        int MOD = (int)1e9 + 7;

        // 预处理dp表
        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;    // 初始化边界条件，防止越界访问
        // 根据状态转移方程填写dp表
        for (int i = 4; i <= n; i ++) {
            // 由于数据可能很大，进行加法运算时可能会溢出，因此每一次加法运算后都要取模
            dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
        }

        // 返回结果
        return dp[n];
    }
}
