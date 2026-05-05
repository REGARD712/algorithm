public class GetMaximumGold {
    int[][] grid;
    int m, n;
    boolean[][] visit;
    int ret, count;

    public int getMaximumGold(int[][] givenGrid) {
        grid = givenGrid;
        m = grid.length; n = grid[0].length;
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    count += grid[i][j]; visit[i][j] = true;
                    // 基于当前位置，寻找下一个
                    dfs(i, j); ret = Math.max(ret, count);
                    count -= grid[i][j]; visit[i][j] = false;
                }
            }
        }

        return ret;
    }

    // 向量数组
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public void dfs(int row, int col) {
        // 更新结果
        ret = Math.max(ret, count);

        // 从 [row,col] 位置的四个方向寻找
        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (!visit[x][y] && grid[x][y] != 0) {
                    count += grid[x][y]; visit[x][y] = true;
                    dfs(x, y);
                    count -= grid[x][y]; visit[x][y] = false;
                }
            }
        }
    }
}
