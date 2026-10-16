public class MinCostClimbingStairs {
    // 解法一：以 i 位置为结尾来推导状态转移方程
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
    // 空间优化版本
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;

        // 用滚动数组代替dp表
        int a = 0, b = 0, c = 0;

        // 填表
        for (int i = 2; i <= n; i++) {
            c = Math.min(b+cost[i-1], a+cost[i-2]);
            a = b; b = c;
        }

        // 返回结果
        return c;
    }

    // 解法二：以 i 位置为起始来推导状态转移方程
    public int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;

        // 预处理dp表
        int[] dp = new int[n];
        dp[n - 1] = cost[n - 1]; dp[n - 2] = cost[n - 2];    // 初始化边界条件，防止越界访问
        // 根据状态转移方程填写dp表：从右往左
        for (int i = n - 3; i >= 0; i --) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }

        // 返回结果：可能从0位置开始，也可能从1位置开始，取最小值即可
        return Math.min(dp[0], dp[1]);
    }
    // 空间优化版本
    public int minCostClimbingStairs4(int[] cost) {
        int n = cost.length;

        // 用滚动数组代替dp表
        int a = cost[n-1], b = cost[n-2], c = 0;

        // 填表
        for (int i = n-3; i >= 0; i--) {
            c = Math.min(b+cost[i], a+cost[i]);
            a = b; b = c;
        }

        // 返回结果
        return Math.min(a, b);
    }
}
