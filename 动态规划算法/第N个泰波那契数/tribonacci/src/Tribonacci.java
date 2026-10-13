public class Tribonacci {
    // 优化了空间的版本，空间复杂度：O（1）
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        // 利用滚动数组方法优化空间
        int a = 0, b = 1, c = 1, d = 0;
        for (int i = 3; i <= n; i ++) {
            d = a + b + c;
            a = b; b = c; c = d;
        }

        // 返回结果
        return d;
    }

    // 时间复杂度：O（N）；空间复杂度：O（N）
    public int tribonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        // 1. 预处理dp表
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = dp[2] = 1;   // 初始化边界，防止越界访问
        // 根据状态转移方程填写dp表
        for (int i = 3; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 2. 返回结果
        return dp[n];
    }
}
