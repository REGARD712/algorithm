public class MaxAreaOfIsland {
    int[][] grid;
    boolean[][] visit;
    int m, n, count, ret;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int maxAreaOfIsland(int[][] givenGrid) {
        grid = givenGrid; m = grid.length; n = grid[0].length;
        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 是未被发现的陆地
                if (grid[i][j] == 1 && !visit[i][j]) {
                    count = 0; // 记录岛屿的面积
                    dfs(i, j); // 找到与这块陆地相连的陆地并统计整块岛屿的面积
                    // 更新岛屿面积最大值
                    ret = Math.max(ret, count);
                }
            }
        }
        return ret;
    }

    public void dfs(int row, int col) {
        count++;
        // 标记陆地状态为已发现
        visit[row][col] = true;

        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (grid[x][y] == 1 && !visit[x][y]) {
                    dfs(x, y);
                }
            }
        }
    }
}
