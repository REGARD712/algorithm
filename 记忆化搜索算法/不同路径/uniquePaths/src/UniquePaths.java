public class UniquePaths {
    int[][] memo; // 备忘录

    public int uniquePaths(int m, int n) {
        memo = new int[m+1][n+1]; // 初始化

        return dfs(m, n); // 返回从起点到[m,n]的路径数
    }

    private int dfs(int row, int col) {
        if (row == 0 || col == 0) {
            return 0;
        }

        if (row == 1 && col == 1) {
            memo[row][col] = 1;
            return 1;
        }

        // 先判断memo是否已经计算过
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        // 在展开之前先记录值
        memo[row][col] = dfs(row-1, col) + dfs(row, col-1);
        return memo[row][col];
    }
}
