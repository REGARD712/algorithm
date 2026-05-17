public class NumIslands {
    char[][] grid;
    boolean[][] visit;
    int m, n, ret;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int numIslands(char[][] givenGrid) {
        grid = givenGrid; m = grid.length; n = grid[0].length;
        visit = new boolean[m][n];

        // 循环遍历，找到未被标记的陆地
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    // 找到一块未被标记的陆地
                    ret++;
                    dfs(i, j); // 找到与这块陆地相连的其他陆地
                }
            }
        }
        return ret;
    }

    private void dfs(int row, int col) {
        // 先将当前位置标记
        visit[row][col] = true;

        // 从当前位置的左右上下四个方向寻找陆地
        for (int k = 0; k < 4; k++) {
            int x = row + dx[k], y = col + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (grid[x][y] == '1' && !visit[x][y]) {
                    dfs(x, y);
                }
            }
        }
    }
}
