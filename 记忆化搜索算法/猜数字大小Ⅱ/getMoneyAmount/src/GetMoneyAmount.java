public class GetMoneyAmount {
    int[][] memo; // 备忘录

    public int getMoneyAmount(int n) {
        memo = new int[n+1][n+1];

        return dfs(1, n); // 在区间中找最小值
    }

    private int dfs(int start, int end) {
        // 边界情况
        if (start >= end) {
            return 0;
        }
        // 如果值已经在备忘录中存过，直接返回
        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        // 遍历区间中的每个数字，计算出最坏情况下的金额
        int ret = Integer.MAX_VALUE, left = 0, right = 0;
        for (int i = start; i <= end; i++) {
            left = dfs(start, i-1);
            right = dfs(i+1, end);
            ret = Math.min(Math.max(left, right) + i, ret);
        }
        // 返回之前存入备忘录
        memo[start][end] = ret;
        return ret;
    }
}
