import java.util.Arrays;

public class UniquePaths {
    int[][] memo; // 记忆数组

    public int uniquePaths(int m, int n) {
        // 初始化
        memo = new int[m+1][n+1];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }

        return dfs(m, n);
    }

    // dfs任务:返回到达[row,col]位置的路径数
    public int dfs (int row, int col) {
        // 递归展开之前,先查看记忆数组
        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        // 非法情况(下标从1开始)
        if (row == 0 || col == 0) {

            return 0;
        }
        // 位于起始位置
        if (row == 1 && col == 1) {
            return 1;
        }

        // 递归展开之后先将结果存入记忆数组
        memo[row][col] = dfs(row-1, col) + dfs(row, col-1);

        return memo[row][col];
    }
}
